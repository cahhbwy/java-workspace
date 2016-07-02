package work2;

import java.util.Random;

public class RandomWalker {

	public static void main(String[] args) {
		int x = 0, y = 0;
		int n = Integer.parseInt(args[0]);
		for (int i = 0; i < n; i++) {
			int t;
			Random rand = new Random();
			t = Math.abs(rand.nextInt()) % 400;
			if (t < 200)
				if (t < 100)
					x++;
				else
					y++;
			else if (t < 300)
				x--;
			else
				y--;
			System.out.println(t + "(" + x + "," + y + ")");
		}
		System.out.println("squared distance = " + (x * x + y * y));
	}

}
