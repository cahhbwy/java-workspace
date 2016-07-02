package russian;

import java.awt.*;
import javax.swing.JOptionPane;

public class Part extends Thread {
	int dir;
	int x, y,tempy;
	static Part part;
	static Object pt;
	static Board board;
	static boolean[][] bd;
	static Point[] p;
	static int score;
	static int grade;
	static int speed;
	static int next;
	static Sleep sleep;
	static boolean yb;
	
	public class PartOfI {
		Color c;

		public PartOfI() {
			dir = (int) (Math.random() * 2);
			c = Color.yellow;
			for (int i = 0; i < 4; i++) {
				p[i] = new Point();
			}
			setp(x, y);
		}

		public void setp(int m, int n) {
			switch (dir % 2) {
			case 0: {
				p[0].x = m;
				p[0].y = n;
				p[1].x = m;
				p[1].y = n + 1;
				p[2].x = m;
				p[2].y = n + 2;
				p[3].x = m;
				p[3].y = n - 1;
			}
				break;
			default: {
				p[0].x = m;
				p[0].y = n;
				p[1].x = m + 1;
				p[1].y = n;
				p[2].x = m + 2;
				p[2].y = n;
				p[3].x = m - 1;
				p[3].y = n;
			}
				break;
			}
		}

		public void draw(int m, int n) {
			setp(m, n);
			StdDraw.setPenColor(c);
			for (int i = 0; i < 4; i++) {
				StdDraw.filledRectangle(p[i].x, p[i].y, 0.5, 0.5);
			}
		}
	}

	public class PartOfL {
		Color c;

		public PartOfL() {
			dir = (int) (Math.random() * 4);
			c = Color.BLUE;
			for (int i = 0; i < 4; i++) {
				p[i] = new Point();
			}
			setp(x, y);
		}

		public void setp(int m, int n) {
			switch (dir % 4) {
			case 0: {
				p[0].x = m;
				p[0].y = n;
				p[1].x = m;
				p[1].y = n + 1;
				p[2].x = m;
				p[2].y = n - 1;
				p[3].x = m + 1;
				p[3].y = n - 1;
			}
				break;
			case 1: {
				p[0].x = m;
				p[0].y = n;
				p[1].x = m + 1;
				p[1].y = n;
				p[2].x = m - 1;
				p[2].y = n;
				p[3].x = m - 1;
				p[3].y = n - 1;
			}
				break;
			case 2: {
				p[0].x = m;
				p[0].y = n;
				p[1].x = m - 1;
				p[1].y = n + 1;
				p[2].x = m;
				p[2].y = n + 1;
				p[3].x = m;
				p[3].y = n - 1;
			}
				break;
			default: {
				p[0].x = m;
				p[0].y = n;
				p[1].x = m + 1;
				p[1].y = n + 1;
				p[2].x = m - 1;
				p[2].y = n;
				p[3].x = m + 1;
				p[3].y = n;
			}
				break;
			}
		}

		public void draw(int m, int n) {
			setp(m, n);
			StdDraw.setPenColor(c);
			for (int i = 0; i < 4; i++) {
				StdDraw.filledRectangle(p[i].x, p[i].y, 0.5, 0.5);
			}
		}
	}

	public class PartOfJ {
		Color c;

		public PartOfJ() {
			dir = (int) (Math.random() * 4);
			c = Color.GREEN;
			for (int i = 0; i < 4; i++) {
				p[i] = new Point();
			}
			setp(x, y);
		}

		public void setp(int m, int n) {
			switch (dir % 4) {
			case 0: {
				p[0].x = m;
				p[0].y = n;
				p[1].x = m;
				p[1].y = n + 1;
				p[2].x = m;
				p[2].y = n - 1;
				p[3].x = m - 1;
				p[3].y = n - 1;
			}
				break;
			case 1: {
				p[0].x = m;
				p[0].y = n;
				p[1].x = m + 1;
				p[1].y = n;
				p[2].x = m - 1;
				p[2].y = n;
				p[3].x = m - 1;
				p[3].y = n + 1;
			}
				break;
			case 2: {
				p[0].x = m;
				p[0].y = n;
				p[1].x = m + 1;
				p[1].y = n + 1;
				p[2].x = m;
				p[2].y = n + 1;
				p[3].x = m;
				p[3].y = n - 1;
			}
				break;
			default: {
				p[0].x = m;
				p[0].y = n;
				p[1].x = m + 1;
				p[1].y = n - 1;
				p[2].x = m - 1;
				p[2].y = n;
				p[3].x = m + 1;
				p[3].y = n;
			}
				break;
			}
		}

		public void draw(int m, int n) {
			setp(x, y);
			StdDraw.setPenColor(c);
			for (int i = 0; i < 4; i++) {
				StdDraw.filledRectangle(p[i].x, p[i].y, 0.5, 0.5);
			}
		}
	}

	public class PartOfT {
		Color c;

		public PartOfT() {
			dir = (int) (Math.random() * 4);
			c = Color.red;
			for (int i = 0; i < 4; i++) {
				p[i] = new Point();
			}
			setp(x, y);
		}

		public void setp(int m, int n) {
			switch (dir % 4) {
			case 0: {
				p[0].x = m;
				p[0].y = n;
				p[1].x = m;
				p[1].y = n + 1;
				p[2].x = m - 1;
				p[2].y = n;
				p[3].x = m + 1;
				p[3].y = n;
			}
				break;
			case 1: {
				p[0].x = m;
				p[0].y = n;
				p[1].x = m + 1;
				p[1].y = n;
				p[2].x = m;
				p[2].y = n + 1;
				p[3].x = m;
				p[3].y = n - 1;
			}
				break;
			case 2: {
				p[0].x = m;
				p[0].y = n;
				p[1].x = m;
				p[1].y = n - 1;
				p[2].x = m - 1;
				p[2].y = n;
				p[3].x = m + 1;
				p[3].y = n;
			}
				break;
			default: {
				p[0].x = m;
				p[0].y = n;
				p[1].x = m - 1;
				p[1].y = n;
				p[2].x = m;
				p[2].y = n + 1;
				p[3].x = m;
				p[3].y = n - 1;
			}
				break;
			}

		}

		public void draw(int m, int n) {
			setp(m, n);
			for (int i = 0; i < 4; i++) {
				StdDraw.setPenColor(c);
				StdDraw.filledRectangle(p[i].x, p[i].y, 0.5, 0.5);
			}
		}
	}

	public class PartOfO {
		Color c;

		public PartOfO() {
			c = Color.orange;
			for (int i = 0; i < 4; i++) {
				p[i] = new Point();
			}
			setp(x, y);
		}

		public void setp(int m, int n) {
			p[0].x = m;
			p[0].y = n;
			p[1].x = m;
			p[1].y = n + 1;
			p[2].x = m + 1;
			p[2].y = n;
			p[3].x = m + 1;
			p[3].y = n + 1;
		}

		public void draw(int m, int n) {
			setp(m, n);
			StdDraw.setPenColor(c);
			for (int i = 0; i < 4; i++) {
				StdDraw.filledRectangle(p[i].x, p[i].y, 0.5, 0.5);
			}
		}
	}

	public class PartOf2 {
		Color c;

		public PartOf2() {
			dir = (int) (Math.random() * 2);

			c = Color.MAGENTA;
			for (int i = 0; i < 4; i++) {
				p[i] = new Point();
			}
			setp(x, y);
		}

		public void setp(int m, int n) {
			switch (dir % 2) {
			case 0: {
				p[0].x = m;
				p[0].y = n;
				p[1].x = m + 1;
				p[1].y = n;
				p[2].x = m;
				p[2].y = n + 1;
				p[3].x = m - 1;
				p[3].y = n + 1;
			}
				break;
			default: {
				p[0].x = m;
				p[0].y = n;
				p[1].x = m - 1;
				p[1].y = n;
				p[2].x = m;
				p[2].y = n + 1;
				p[3].x = m - 1;
				p[3].y = n - 1;
			}
				break;
			}
		}

		public void draw(int m, int n) {
			setp(m, n);
			StdDraw.setPenColor(c);
			for (int i = 0; i < 4; i++) {
				StdDraw.filledRectangle(p[i].x, p[i].y, 0.5, 0.5);
			}
		}
	}

	public class PartOf5 {
		Color c;

		public PartOf5() {
			dir = (int) (Math.random() * 2);
			c = Color.pink;
			for (int i = 0; i < 4; i++) {
				p[i] = new Point();
			}
			setp(x, y);
		}

		public void setp(int m, int n) {
			switch (dir % 2) {
			case 0: {
				p[0].x = m;
				p[0].y = n;
				p[1].x = m - 1;
				p[1].y = n;
				p[2].x = m;
				p[2].y = n + 1;
				p[3].x = m + 1;
				p[3].y = n + 1;
			}
				break;
			default: {
				p[0].x = m;
				p[0].y = n;
				p[1].x = m - 1;
				p[1].y = n;
				p[2].x = m;
				p[2].y = n - 1;
				p[3].x = m - 1;
				p[3].y = n + 1;
			}
				break;
			}
		}

		public void draw(int m, int n) {
			setp(m, n);
			StdDraw.setPenColor(c);
			for (int i = 0; i < 4; i++) {
				StdDraw.filledRectangle(p[i].x, p[i].y, 0.5, 0.5);
			}
		}
	}

	public Part() {
		sleep = new Sleep();
		x = 7;
		y = 32;
		score = 0;
		grade = 0;
		speed = 1000;
		yb=true;
		bd = new boolean[16][36];
		p = new Point[4];
		next = (int) (Math.random() * 7);
		for (int i = 0; i < 16; i++) {
			for (int j = 0; j < 35; j++) {
				bd[i][j] = false;
			}
		}
	}

	public void newpt() {
		x = 7;
		y = 32;
		switch (next) {
		case 0:
			pt = part.new PartOfI();
			break;
		case 1:
			pt = part.new PartOfJ();
			break;
		case 2:
			pt = part.new PartOfL();
			break;
		case 3:
			pt = part.new PartOfO();
			break;
		case 4:
			pt = part.new PartOf2();
			break;
		case 5:
			pt = part.new PartOf5();
			break;
		default:
			pt = part.new PartOfT();
			break;
		}
		next = (int) (Math.random() * 7);
	}

	public void control(char t) {
		tempy=y;
		boolean temp = false;
		switch (t) {
		case '4':
		case 'a':
		case 'A': {
			for (int i = 0; i < 4; i++) {
				if (p[i].x <= 0 || bd[p[i].x - 1][p[i].y]) {
					temp = true;
				}
			}
			if (!temp) {
				x--;
			}
		}
			break;
		case '6':
		case 'd':
		case 'D': {
			for (int i = 0; i < 4; i++) {
				if (p[i].x >= 15 || bd[p[i].x + 1][p[i].y]) {
					temp = true;
				}
			}
			if (!temp) {
				x++;
			}
		}
			break;
		case '8':
		case 'w':
		case 'W': {
			dir = (dir + 1) % 4;
			if (pt instanceof PartOfI) {
				((PartOfI) pt).setp(x, y);
			} else if (pt instanceof PartOfJ) {
				((PartOfJ) pt).setp(x, y);
			} else if (pt instanceof PartOfO) {
				((PartOfO) pt).setp(x, y);
			} else if (pt instanceof PartOfL) {
				((PartOfL) pt).setp(x, y);
			} else if (pt instanceof PartOfT) {
				((PartOfT) pt).setp(x, y);
			} else if (pt instanceof PartOf2) {
				((PartOf2) pt).setp(x, y);
			} else if (pt instanceof PartOf5) {
				((PartOf5) pt).setp(x, y);
			}
			for (int i = 0; i < 4; i++) {
				if (p[i].x < 0 || p[i].x > 15 || bd[p[i].x][p[i].y]) {
					temp = true;
				}
			}
			if (temp) {
				dir = (dir + 3) % 4;
				if (pt instanceof PartOfI) {
					((PartOfI) pt).setp(x, y);
				} else if (pt instanceof PartOfJ) {
					((PartOfJ) pt).setp(x, y);
				} else if (pt instanceof PartOfO) {
					((PartOfO) pt).setp(x, y);
				} else if (pt instanceof PartOfL) {
					((PartOfL) pt).setp(x, y);
				} else if (pt instanceof PartOfT) {
					((PartOfT) pt).setp(x, y);
				} else if (pt instanceof PartOf2) {
					((PartOf2) pt).setp(x, y);
				} else if (pt instanceof PartOf5) {
					((PartOf5) pt).setp(x, y);
				}
			}
		}
			break;
		case '5':
		case 's':
		case 'S': {
			yb=false;
			boolean b = false;
			for (int i = 0; i < 4; i++) {
				if (p[i].y < 1 || bd[p[i].x][p[i].y - 1]) {
					b = true;
					break;
				}
			}
			if (!b) {
				y--;
				tempy=y;
			}
			check();
			yb=true;
		}
			break;
		case ' ':
		case '\n':
			JOptionPane.showMessageDialog(null, "ÔÝÍ£ÖÐ");
			break;
		default:
			break;
		}
	}

	public void show(Object pt, int m, int n) {
		StdDraw.clear();
		board.draw();
		for (int i = 0; i < 16; i++) {
			for (int j = 0; j < 35; j++) {
				if (bd[i][j]) {
					StdDraw.setPenColor(Color.cyan);
					StdDraw.filledRectangle(i, j, 0.5, 0.5);
				}
			}
		}
		if (pt instanceof PartOfI) {
			((PartOfI) pt).draw(m, n);
		} else if (pt instanceof PartOfJ) {
			((PartOfJ) pt).draw(m, n);
		} else if (pt instanceof PartOfO) {
			((PartOfO) pt).draw(m, n);
		} else if (pt instanceof PartOfL) {
			((PartOfL) pt).draw(m, n);
		} else if (pt instanceof PartOfT) {
			((PartOfT) pt).draw(m, n);
		} else if (pt instanceof PartOf2) {
			((PartOf2) pt).draw(m, n);
		} else if (pt instanceof PartOf5) {
			((PartOf5) pt).draw(m, n);
		}
	}

	public void check() {
		boolean b = false;
		for (int i = 0; i < 4; i++) {
			if (p[i].y == 0 || bd[p[i].x][p[i].y - 1]) {
				b = true;
				break;
			}
			if (p[i].y < 0 || y!=tempy){
				y=(y+1>tempy?y+1:tempy);
				if (pt instanceof PartOfI) {
					((PartOfI) pt).setp(x, y);
				} else if (pt instanceof PartOfJ) {
					((PartOfJ) pt).setp(x, y);
				} else if (pt instanceof PartOfO) {
					((PartOfO) pt).setp(x, y);
				} else if (pt instanceof PartOfL) {
					((PartOfL) pt).setp(x, y);
				} else if (pt instanceof PartOfT) {
					((PartOfT) pt).setp(x, y);
				} else if (pt instanceof PartOf2) {
					((PartOf2) pt).setp(x, y);
				} else if (pt instanceof PartOf5) {
					((PartOf5) pt).setp(x, y);
				}
			}
		}
		if (b) {
			for (int i = 0; i < 4; i++) {
				bd[p[i].x][p[i].y] = true;
			}
			part.newpt();
		}
	}

	public void scgr() {
		int line = 0;
		boolean state;
		for (int j = 0; j < 35; j++) {
			state = true;
			for (int i = 0; i < 16; i++) {
				if (!bd[i][j]) {
					state = false;
					break;
				}
			}
			if (state) {
				line++;
				for (int k = j; k < 34; k++) {
					for (int i = 0; i < 16; i++) {
						bd[i][k] = bd[i][k + 1];
					}
				}
				for (int i = 0; i < 16; i++) {
					bd[i][35] = false;
				}
				j--;
			}
		}
		for (int i = 0; i <= line; i++) {
			score += (i * 100);
		}
		grade = score / 1000;
		speed = grade < 10 ? 1000 - grade * 100 : 100;
	}

	@SuppressWarnings("deprecation")
	public boolean alive() {
		for (int i = 0; i < 4; i++) {
			if (p[i].y >= 32 && bd[p[i].x][p[i].y]) {
				sleep.stop();
				return false;
			}
		}
		return true;
	}

	public void run() {
		while (part.alive()) {
			StdDraw.show();
			while (StdDraw.hasNextKeyTyped()) {
				part.control(StdDraw.nextKeyTyped());
				part.show(pt, x, y);
			}
			part.show(pt, x, y);
			part.scgr();
		}
		StdDraw.setPenRadius(0.015);
		StdDraw.setPenColor(Color.blue);
		StdDraw.filledRectangle(7.5, 17.5, 6.5, 4.5);
		StdDraw.setPenColor(Color.cyan);
		StdDraw.filledRectangle(7.5, 17.5, 5.5, 3.5);
		StdDraw.setPenColor(Color.red);
		StdDraw.text(7.5, 17.5, "Failed!\nYour score is " + score);
		Game.restart();
	}

	class Sleep extends Thread {
		public void run() {
			while (true) {
				try {
					Thread.sleep(Part.speed);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				boolean b = false;
				for (int i = 0; i < 4; i++) {
					if (p[i].y <= 0
							|| bd[p[i].x][p[i].y - 1]) {
						b = true;
						break;
					}
				}
//				Part.part.check();
				if (!b&&yb) {
					part.y--;
					tempy=y;
				}
				part.check();
			}
		}
	}
}
