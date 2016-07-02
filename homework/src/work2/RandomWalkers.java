package work2;

import java.util.Random;

public class RandomWalkers {

	public static void main(String[] args) {
		int x, y;
		long sum = 0;
		int n = Integer.parseInt(args[0]);
		int t = Integer.parseInt(args[1]);
		for (int k = 0; k < t; k++) {
			x = y = 0;
			for (int i = 0; i < n; i++) {
				int f;
				Random rand = new Random();
				f = Math.abs(rand.nextInt()) % 400;
				if (f < 200)
					if (f < 100)
						x++;
					else
						y++;
				else if (f < 300)
					x--;
				else
					y--;
			}
			sum += x * x + y * y;
		}
		System.out.println("mean squared distance = " + (double) sum / t);
	}

}
