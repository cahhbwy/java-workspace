package work5;

import edu.princeton.cs.introcs.*;

public class LFSR {
	// declare instance variables
	private int N; // number of bits in the LFSR
	private int[] reg; // reg[i] = ith bit of LFSR, reg[0] is rightmost bit
	private int tap; // index of the tap bit

	// constructor to create LFSR with the given initial seed and tap
	public LFSR(String seed, int t) {
		N = seed.length();
		tap = t;
		reg = new int[N];
		char[] charTemp = seed.toCharArray();
		for (int i = 0; i < N; i++) {
			reg[i] = charTemp[N - 1 - i] - '0';
		}

	}

	// simulate one step and return the new bit as 0 or 1
	public int step() {
		int temp = reg[N - 1] ^ reg[tap];
		for (int i = N - 1; i > 0; i--) {
			reg[i] = reg[i - 1];
		}
		reg[0] = temp;
		return reg[0];

	}

	// simulate k steps and return k-bit integer
	public int generate(int k) {
		for (int i = 0; i < k; i++)
			step();
		String y = "";
		for (int i = 0; i < k; i++) {
			y = String.valueOf(reg[i]) + y;
		}
		int temp = Integer.parseInt(y, 2);
		return temp;
	}

	// return a string representation of the LFSR
	public String toString() {
		String StringTemp = "";
		for (int i = 0; i < N; i++) {
			StringTemp = String.valueOf(reg[i]) + StringTemp;
		}
		return StringTemp;
	}

	// test client
	public static void main(String[] args) {
		LFSR lfsr = new LFSR("01101000010", 8);
		StdOut.println(lfsr);
		StdOut.println();

		LFSR lfsr1 = new LFSR("01101000010", 8);
		for (int i = 0; i < 10; i++) {
			int bit = lfsr1.step();
			StdOut.println(lfsr1 + " " + bit);
		}
		StdOut.println();

		LFSR lfsr2 = new LFSR("01101000010", 8);
		for (int i = 0; i < 10; i++) {
			int r = lfsr2.generate(5);
			StdOut.println(lfsr2 + " " + r);
		}
		StdOut.println();

		LFSR lfsr3 = new LFSR("01101000010100010000", 16);
		for (int i = 0; i < 10; i++) {
			int r = lfsr3.generate(8);
			StdOut.println(lfsr3 + " " + r);
		}
	}

}
