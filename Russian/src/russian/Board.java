package russian;

import java.awt.*;

public class Board {
	Point[] p = new Point[4];
	static int width = 16, height = 35;
	static int xca = 450, yca = 600;
	static int x = 22, y = 27;

	public Board() {
		for (int i = 0; i < 4; i++) {
			p[i] = new Point();
		}
		StdDraw.setCanvasSize(xca, yca);
		StdDraw.setXscale(-2, 28);
		StdDraw.setYscale(-2, 38);
		this.draw();
	}

	public void next(int m, int n) {
		Color c;
		switch (Part.next % 7) {
		case 0: {
			c = Color.yellow;
			p[0].x = x;
			p[0].y = y;
			p[1].x = x;
			p[1].y = y + 1;
			p[2].x = x;
			p[2].y = y + 2;
			p[3].x = x;
			p[3].y = y - 1;
		}
			break;
		case 1: {
			c = Color.GREEN;
			p[0].x = x + 1;
			p[0].y = y;
			p[1].x = x + 1;
			p[1].y = y + 1;
			p[2].x = x + 1;
			p[2].y = y - 1;
			p[3].x = x;
			p[3].y = y - 1;
		}
			break;
		case 2: {
			c = Color.BLUE;
			p[0].x = x;
			p[0].y = y;
			p[1].x = x;
			p[1].y = y + 1;
			p[2].x = x;
			p[2].y = y - 1;
			p[3].x = x + 1;
			p[3].y = y - 1;
		}
			break;
		case 3: {
			c = Color.ORANGE;
			p[0].x = x;
			p[0].y = y;
			p[1].x = x;
			p[1].y = y + 1;
			p[2].x = x + 1;
			p[2].y = y;
			p[3].x = x + 1;
			p[3].y = y + 1;
		}
			break;
		case 4: {
			c = Color.MAGENTA;
			p[0].x = x + 1;
			p[0].y = y;
			p[1].x = x + 2;
			p[1].y = y;
			p[2].x = x + 1;
			p[2].y = y + 1;
			p[3].x = x;
			p[3].y = y + 1;
		}
			break;
		case 5: {
			c = Color.PINK;
			p[0].x = x;
			p[0].y = y;
			p[1].x = x - 1;
			p[1].y = y;
			p[2].x = x;
			p[2].y = y + 1;
			p[3].x = x + 1;
			p[3].y = y + 1;
		}
			break;
		default: {
			c = Color.red;
			p[0].x = x;
			p[0].y = y;
			p[1].x = x;
			p[1].y = y + 1;
			p[2].x = x - 1;
			p[2].y = y;
			p[3].x = x + 1;
			p[3].y = y;
		}
			break;
		}
		StdDraw.setPenColor(c);
		for (int i = 0; i < 4; i++) {
			StdDraw.filledRectangle(p[i].x, p[i].y, 0.5, 0.5);
		}
	}

	public void draw() {
		next(22, 27);
		StdDraw.setPenRadius(0.015);
		StdDraw.setPenColor(Color.blue);
		StdDraw.rectangle(7.5, 17, 8.3, 17.8);
		StdDraw.setPenColor(Color.lightGray);
		StdDraw.setPenRadius();
		for (int i = 0; i < 34; i++) {
			StdDraw.line(-0.5, i + 0.5, 15.5, i + 0.5);
		}
		for (int i = 0; i < 15; i++) {
			StdDraw.line(i + 0.5, -0.5, i + 0.5, 34.5);
		}
		StdDraw.setPenColor(Color.red);
		StdDraw.setPenRadius(0.01);
		StdDraw.rectangle(22.5, 27.5, 2.2, 2.2);
		StdDraw.setPenColor(Color.lightGray);
		StdDraw.setPenRadius();
		for (int i = 0; i < 3; i++) {
			StdDraw.line(i + 21.5, 25.5, i + 21.5, 29.5);
		}
		for (int i = 0; i < 3; i++) {
			StdDraw.line(20.5, i + 26.5, 24.5, i + 26.5);
		}
		StdDraw.setPenColor();
		StdDraw.textLeft(18, 31, "Next");
		StdDraw.textLeft(18, 21, "Score:");
		StdDraw.textRight(23, 19, "" + Part.score);
		StdDraw.textLeft(18, 15, "Grade:");
		StdDraw.textRight(23, 13, "" + Part.grade);

	}

	public static void main(String[] args) {
		new Board();
	}

}
