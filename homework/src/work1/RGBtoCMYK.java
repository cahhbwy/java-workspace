package work1;

public class RGBtoCMYK {

	public static void main(String[] args) {
		double r = Double.parseDouble(args[0]);
		double g = Double.parseDouble(args[1]);
		double b = Double.parseDouble(args[2]);
		double w, c, m, y, k;
		w = Math.max(Math.max(r / 255, g / 255), b / 255);
		if (r == 0 && g == 0 && b == 0) {
			c = m = y = 0;
		} else {
			c = (w - r / 255) / w;
			m = (w - g / 255) / w;
			y = (w - b / 255) / w;
		}
		k = 1 - w;
		System.out.println("cyan    = " + c);
		System.out.println("magenta = " + m);
		System.out.println("yellow  = " + y);
		System.out.println("black   = " + k);
	}

}
