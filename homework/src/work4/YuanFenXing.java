package work4;

import edu.princeton.cs.introcs.StdDraw;

public class YuanFenXing {
	static double t = Math.sqrt(3.0) / 2.0;

	public static void draw(int n, double hx, double hy, double r) {
		if (n == 1)
			return;
		double[] x = new double[7];
		double[] y = new double[7];

		x[0] = hx;
		x[1] = hx + r * 2.0 / 3.0;
		x[2] = x[6] = hx + r / 3.0;
		x[3] = x[5] = hx - r / 3.0;
		x[4] = hx - r * 2.0 / 3.0;
		y[0] = y[1] = y[4] = hy;
		y[2] = y[3] = hy - t * r * 2.0 / 3.0;
		y[5] = y[6] = hy + t * r * 2.0 / 3.0;

		int red = (int) (Math.random() * 255);
		int green = (int) (Math.random() * 255);
		int blue = (int) (Math.random() * 255);
		StdDraw.setPenColor(red, green, blue);
		for (int i = 0; i < 7; i++) {

			StdDraw.filledCircle(x[i], y[i], r / 3.0);
			draw(n - 1, x[i], y[i], r / 3.0);
		}

	}

	public static void main(String[] args) {
		StdDraw.setScale(-3.0, 3.0);
		int n = Integer.parseInt(args[0]);
		int red = (int) (Math.random() * 255);
		int green = (int) (Math.random() * 255);
		int blue = (int) (Math.random() * 255);
		StdDraw.setPenColor(red, green, blue);
		StdDraw.filledCircle(0.0, 0.0, 3.0);

		draw(n, 0.0, 0.0, 3.0);

	}

}
