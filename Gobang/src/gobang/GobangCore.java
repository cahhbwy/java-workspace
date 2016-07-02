package gobang;

import java.awt.*;
import java.io.*;
import java.util.*;

public class GobangCore {
	int size;
	short[][] chess;
	boolean player;
	boolean setPlayer;
	int number;

	class Record {
		int x;
		int y;
		boolean player;

		public Record(int x, int y, boolean player) {
			this.x = x;
			this.y = y;
			this.player = player;
		}
	}

	Stack<Record> records;

	public GobangCore(int size, boolean player) {
		this.size = size;
		this.number = size * size;
		this.player = player;
		this.setPlayer = player;
		this.chess = new short[size][size];
		records = new Stack<>();
	}

	public GobangCore(String fileName) throws FileNotFoundException {
		File file = new File(fileName);
		FileInputStream fis = new FileInputStream(file);
		Scanner sc = new Scanner(fis);
		this.size = sc.nextInt();
		this.number = size * size;
		this.player = sc.nextBoolean();
		this.setPlayer = this.player;
		this.chess = new short[size][size];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				chess[i][j] = sc.nextShort();
				if (chess[i][j] != 0)
					number--;
			}
		}
		sc.close();
		try {
			fis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (!judge()) {
			System.out.println("The initial conditions of gobang has error!");
			chess = new short[size][size];
		}
		records = new Stack<>();
	}

	public GobangCore(int size, boolean player, short[][] chess) {
		this.size = size;
		this.player = player;
		this.chess = chess.clone();
		if (!judge()) {
			System.out.println("The initial conditions of gobang has error!");
			chess = new short[size][size];
		}
		records = new Stack<>();
	}

	public static void main(String[] args) {
		// GobangCore gobangCore = new GobangCore(15, true);
		GobangCore gobangCore;
		try {
			gobangCore = new GobangCore("GobangSave.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return;
		}
		boolean state = true;
		Point p;
		Scanner sc = new Scanner(System.in);
		int select = 0;
		do {
			gobangCore.printChess();
			if (gobangCore.player) {
				select = sc.nextInt();
				p = gobangCore.control(select, sc);
			} else {
				p = gobangCore.computer(true);
				gobangCore.setInput(p.x, p.y);
			}
			if (p == null) {
				state = true;
			} else {
				state = !gobangCore.check(p.x, p.y);
			}
			if (gobangCore.number <= 0) {
				sc.close();
				gobangCore.printChess();
				System.out.println("Ahahaha......a draw!!\n");
				System.out.println("*************Little Monk*************");
				System.out.println("https://github.com/cahhbwy/Gobang_Java");
				return;
			}
		} while (state);
		sc.close();
		gobangCore.printChess();
		if (!gobangCore.player) {
			System.out.println("Well done! You win!!\n");
		} else {
			System.out.println("Sorry, you failed\n");
		}
	}

	boolean check(int x, int y) {
		if (value(x, y, !player) > 8000000) {
			return true;
		}
		return false;
	}

	Point computer(boolean state) {
		int halfsize = size / 2;
		int[][] value1 = new int[size][size], value2 = new int[size][size];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (chess[i][j] == 0) {
					chess[i][j] = 1;
					value1[i][j] = value(i, j, true) + 128 - (i - halfsize) * (i - halfsize)
							- (j - halfsize) * (j - halfsize);
					chess[i][j] = 2;
					value2[i][j] = value(i, j, false) + 128 - (i - halfsize) * (i - halfsize)
							- (j - halfsize) * (j - halfsize);
					chess[i][j] = 0;
					value1[i][j] = value1[i][j] > 8388607 ? 8388608 : value1[i][j];
					value2[i][j] = value2[i][j] > 8388607 ? 8388608 : value2[i][j];
				} else {
					value1[i][j] = value2[i][j] = 0;
				}
			}
		}
		int max1x = -1, max1y = -1, max2x = -1, max2y = -1, max1 = 0, max2 = 0;
		Random random = new Random();
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (max1 < value1[i][j] || (max1 == value1[i][j] && random.nextBoolean())) {
					max1x = i;
					max1y = j;
					max1 = value1[i][j];
				}
				if (max2 < value2[i][j] || (max2 == value2[i][j] && random.nextBoolean())) {
					max2x = i;
					max2y = j;
					max2 = value2[i][j];
				}
			}
		}
		Point point = new Point();
		if (max1 < max2) {
			point.x = max2x;
			point.y = max2y;
		} else if (max1 > max2) {
			point.x = max1x;
			point.y = max1y;
		} else {
			if (state) {
				point.x = max2x;
				point.y = max2y;
			} else {
				point.x = max1x;
				point.y = max1y;
			}
		}
		return point;
	}

	private int value(int x, int y, boolean player) {
		short play = (short) (player ? 1 : 2);
		int v = 0, k;
		int up, down, left, right, x1, x2, y1, y2;
		up = x - 4 > 0 ? x - 4 : 0;
		down = x + 4 < size - 1 ? x + 4 : size - 1;
		left = y - 4 > 0 ? y - 4 : 0;
		right = y + 4 < size - 1 ? y + 4 : size - 1;
		// 横向
		x1 = x2 = x;
		while (x1 >= up && chess[x1][y] == play)
			x1--;
		while (x2 <= down && chess[x2][y] == play)
			x2++;
		if (x2 - x1 < 6) {
			k = 64 << (x2 - x1);
		} else {
			return 8388608;
		}
		if (x1 == -1 || chess[x1][y] == (play ^ 3))
			k /= 2;
		if (x2 == size || chess[x2][y] == (play ^ 3))
			k /= 2;
		v += k;
		// 纵向
		y1 = y2 = y;
		while (y1 >= left && chess[x][y1] == play)
			y1--;
		while (y2 <= right && chess[x][y2] == play)
			y2++;
		if (y2 - y1 < 6) {
			k = 64 << (y2 - y1);
		} else {
			return 8388608;
		}
		if (y1 == -1 || chess[x][y1] == (play ^ 3))
			k /= 2;
		if (y2 == size || chess[x][y2] == (play ^ 3))
			k /= 2;
		v += k;
		// 右下
		x1 = x2 = x;
		y1 = y2 = y;
		while (x1 >= up && y1 >= left && chess[x1][y1] == play) {
			x1--;
			y1--;
		}
		while (x2 <= down && y2 <= right && chess[x2][y2] == play) {
			x2++;
			y2++;
		}
		if (x2 - x1 < 6) {
			k = 64 << (x2 - x1);
		} else {
			return 8388608;
		}
		if (x1 == -1 || y1 == -1 || chess[x1][y1] == (play ^ 3))
			k /= 2;
		if (x2 == size || y2 == size || chess[x2][y2] == (play ^ 3))
			k /= 2;
		v += k;
		// 左下
		x1 = x2 = x;
		y1 = y2 = y;
		while (x1 >= up && y2 <= right && chess[x1][y2] == play) {
			x1--;
			y2++;
		}
		while (x2 <= down && y1 >= left && chess[x2][y1] == play) {
			x2++;
			y1--;
		}
		if (x2 - x1 < 6) {
			k = 64 << (y2 - y1);
		} else {
			return 8388608;
		}
		if (x1 == -1 || y2 == size || chess[x1][y2] == (play ^ 3))
			k /= 2;
		if (x2 == size || y1 == -1 || chess[x2][y1] == (play ^ 3))
			k /= 2;
		v += k;
		return v;
	}

	boolean setInput(int x, int y) {
		if (x < 0 || x > size - 1 || y < 0 || y > size - 1) {
			return false;
		}
		if (chess[x][y] == 0) {
			if (player)
				chess[x][y] = 1;
			else
				chess[x][y] = 2;
			records.push(new Record(x, y, player));
			player = !player;
			this.number--;
			return true;
		} else {
			return false;
		}
	}

	private void printChess() {
		System.out.printf("x\\y0");
		for (int i = 1; i < size; i++) {
			System.out.printf("%2d", i);
		}
		if (chess[0][0] == 0) {
			System.out.printf("\n 0 ┌");
		} else if (chess[0][0] == 1) {
			System.out.printf("\n 0 ●");
		} else if (chess[0][0] == 2) {
			System.out.printf("\n 0 ○");
		} else {
			chess[0][0] = 0;
			System.out.printf("\n 0 ┌");
		}
		for (int j = 1; j < size - 1; j++) {
			if (chess[0][j] == 0) {
				System.out.printf(" ┬");
			} else if (chess[0][j] == 1) {
				System.out.printf(" ●");
			} else if (chess[0][j] == 2) {
				System.out.printf(" ○");
			} else {
				chess[0][j] = 0;
				System.out.printf(" ┬");
			}
		}
		if (chess[0][size - 1] == 0) {
			System.out.printf(" ┐\n");
		} else if (chess[0][size - 1] == 1) {
			System.out.printf(" ●\n");
		} else if (chess[0][size - 1] == 2) {
			System.out.printf(" ○\n");
		} else {
			chess[0][size - 1] = 0;
			System.out.printf(" ┐\n");
		}
		for (int i = 1; i < size - 1; i++) {
			System.out.printf("%2d", i);
			if (chess[i][0] == 0) {
				System.out.printf(" ├");
			} else if (chess[i][0] == 1) {
				System.out.printf(" ●");
			} else if (chess[i][0] == 2) {
				System.out.printf(" ○");
			} else {
				chess[i][0] = 0;
				System.out.printf(" ├");
			}
			for (int j = 1; j < size - 1; j++) {
				if (chess[i][j] == 0) {
					System.out.printf(" ┼");
				} else if (chess[i][j] == 1) {
					System.out.printf(" ●");
				} else if (chess[i][j] == 2) {
					System.out.printf(" ○");
				} else {
					chess[i][j] = 0;
					System.out.printf(" ┼");
				}
			}
			if (chess[i][size - 1] == 0) {
				System.out.printf(" ┤\n");
			} else if (chess[i][size - 1] == 1) {
				System.out.printf(" ●\n");
			} else if (chess[i][size - 1] == 2) {
				System.out.printf(" ○\n");
			} else {
				chess[i][size - 1] = 0;
				System.out.printf(" ┤\n");
			}
		}
		if (chess[size - 1][0] == 0) {
			System.out.printf("%2d └", size - 1);
		} else if (chess[size - 1][0] == 1) {
			System.out.printf("%2d ●", size - 1);
		} else if (chess[size - 1][0] == 2) {
			System.out.printf("%2d ○", size - 1);
		} else {
			chess[size - 1][0] = 0;
			System.out.printf("%2d └", size - 1);
		}
		for (int j = 1; j < size - 1; j++) {
			if (chess[size - 1][j] == 0) {
				System.out.printf(" ┴");
			} else if (chess[size - 1][j] == 1) {
				System.out.printf(" ●");
			} else if (chess[size - 1][j] == 2) {
				System.out.printf(" ○");
			} else {
				chess[size - 1][j] = 0;
				System.out.printf(" ┴");
			}
		}
		if (chess[size - 1][size - 1] == 0) {
			System.out.printf(" ┘\n");
		} else if (chess[size - 1][size - 1] == 1) {
			System.out.printf(" ●\n");
		} else if (chess[size - 1][size - 1] == 2) {
			System.out.printf(" ○\n");
		} else {
			chess[size - 1][size - 1] = 0;
			System.out.printf(" ┘\n");
		}
	}

	public Point back() {
		if (records.empty()) {
			return null;
		}
		Record record = records.pop();
		this.number++;
		chess[record.x][record.y] = 0;
		if (!record.player) {
			if (records.empty()) {
				return null;
			}
			record = records.pop();
			this.number++;
			chess[record.x][record.y] = 0;
		} else {
			player = !player;
		}
		if (records.empty()) {
			return null;
		}
		record = records.lastElement();
		return new Point(record.x, record.y);
	}

	public void save(String fileName) throws FileNotFoundException {
		File file = new File(fileName);
		FileOutputStream fos = new FileOutputStream(file);
		PrintStream ps = new PrintStream(fos);
		ps.println(size);
		ps.println(setPlayer);
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				ps.print(chess[i][j] + " ");
			}
			ps.println();
		}
		ps.close();
		try {
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private boolean judge() {
		int black = 0, white = 0;
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (chess[i][j] == 1) {
					black++;
				} else if (chess[i][j] == 2) {
					white++;
				}
			}
		}
		if (player) {
			if (black - white == 1 || black == white) {
				return true;
			} else {
				return false;
			}
		} else {
			if (white - black == 1 || white == black) {
				return true;
			} else {
				return false;
			}
		}
	}

	public Point control(int select, Scanner sc) {
		Point p;
		switch (select) {
			case 0: // 落子
				p = new Point(sc.nextInt(), sc.nextInt());
				if (!setInput(p.x, p.y)) {
					System.out.println("There has been a chess.");
					return null;
				}
				return p;
			case 1: // 悔棋
				p = back();
				return p;
			case 2: // 提示
				p = computer(false);
				System.out.println("Tips x = " + p.x + " ,y = " + p.y);
				return p;
			case 3: // 保存
				try {
					save("GobangSave.txt");
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				return null;
			default:
				return null;
		}
	}

	public short[][] getChess() {
		return chess;
	}

	public void setChess(short[][] chess) {
		this.chess = chess;
	}

}
