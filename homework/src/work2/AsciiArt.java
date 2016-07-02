package work2;

public class AsciiArt {
	static void first(int x) {
		for (int i = 0; i <= x; i++) {
			System.out.print("|");
			for (int j = 0; j <= x - i; j++)
				System.out.print(" ");
			for (int j = 0; j < i; j++)
				System.out.print("/");
			System.out.print("*");
			for (int j = 0; j < i; j++)
				System.out.print("\\");
			for (int j = 0; j <= x - i; j++)
				System.out.print(" ");
			System.out.println("|");

		}
	}

	static void second(int x) {
		for (int i = x; i >= 0; i--) {
			System.out.print("|");
			for (int j = 0; j <= x - i; j++)
				System.out.print(" ");
			for (int j = 0; j < i; j++)
				System.out.print("\\");
			System.out.print("*");
			for (int j = 0; j < i; j++)
				System.out.print("/");
			for (int j = 0; j <= x - i; j++)
				System.out.print(" ");
			System.out.println("|");

		}
	}

	static void third(int x) {
		System.out.print("+");
		for (int i = 0; i <= 2 * (x + 1); i++)
			System.out.print("-");
		System.out.println("+");
	}

	public static void main(String[] args) {
		int x = Integer.parseInt(args[0]);
		if (x >= 1 && x <= 20) {
			third(x);
			first(x);
			second(x);
			third(x);
			second(x);
			first(x);
			third(x);
		} else
			System.out.println("The number must be between 1 and 20.");

	}

}
