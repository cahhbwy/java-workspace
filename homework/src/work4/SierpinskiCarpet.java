package work4;

import edu.princeton.cs.introcs.StdDraw;

public class SierpinskiCarpet {
	public static void draw(int n, double x, double y, double r) {
		if (n == 1)
			return;
		int red = (int) (Math.random() * 255);
		int green = (int) (Math.random() * 255);
		int blue = (int) (Math.random() * 255);
		StdDraw.setPenColor(red, green, blue);
		StdDraw.filledSquare(x, y, r);
		double[] hx = new double[8];
		double[] hy = new double[8];
		hx[0] = hx[1] = hx[2] = x + r * 2;
		hx[3] = hx[4] = x;
		hx[5] = hx[6] = hx[7] = x - r * 2;
		hy[0] = hy[3] = hy[5] = y + r * 2;
		hy[1] = hy[6] = y;
		hy[2] = hy[4] = hy[7] = y - r * 2;
		for (int i = 0; i < 8; i++) {
			StdDraw.filledSquare(hx[i], hy[i], r / 3);
			draw(n - 1, hx[i], hy[i], r / 3);
		}

	}

	public static void main(String[] args) {
		StdDraw.setScale(-0.5, 0.5);
		int n = Integer.parseInt(args[0]);
		int red = (int) (Math.random() * 255);
		int green = (int) (Math.random() * 255);
		int blue = (int) (Math.random() * 255);
		StdDraw.setPenColor(red, green, blue);
		StdDraw.filledSquare(0.0, 0.0, 0.5);
		draw(n, 0.0, 0.0, 0.5 / 3.0);

	}

}
