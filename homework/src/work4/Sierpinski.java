package work4;

import edu.princeton.cs.introcs.StdDraw;

public class Sierpinski {
	static double t = Math.sqrt(3.0) / 2.0;

	public static void draw(int n, double size, double x, double y) {
		if (n == 0)
			return;
		int red = (int) (Math.random() * 255);
		int green = (int) (Math.random() * 255);
		int blue = (int) (Math.random() * 255);
		StdDraw.setPenColor(red, green, blue);
		double[] hx = new double[3];
		double[] hy = new double[3];
		hx[0] = x + size * 0.25;
		hx[1] = x + size * 0.50;
		hx[2] = x + size * 0.75;
		hy[1] = y;
		hy[0] = hy[2] = y + size * t * 0.5;
		StdDraw.filledPolygon(hx, hy);

		draw(n - 1, size / 2.0, x, y);
		draw(n - 1, size / 2.0, x + size / 2.0, y);
		draw(n - 1, size / 2.0, x + size * 0.25, y + size * t / 2.0);

	}

	public static void main(String[] args) {
		double size = 1.0;

		int n = Integer.parseInt(args[0]);
		double[] x = { 0.0, 0.5, 1.0 };
		double[] y = { 0.0, t, 0.0 };

		StdDraw.filledPolygon(x, y);

		draw(n, size, 0.0, 0.0);

	}

}
