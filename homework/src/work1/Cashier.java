package work1;

public class Cashier {

	public static void main(String[] args) {
		int change = 100 - Integer.parseInt(args[0]);
		int quarters, dime, nickels, pennies;
		quarters = change / 25;
		dime = change % 25 / 10;
		nickels = (change - 25 * quarters - 10 * dime) / 5;
		pennies = (change - 25 * quarters - 10 * dime) % 5;
		System.out.println("Your change of " + change + " cents is given as:");
		System.out.print(quarters + " quarter");
		if (quarters != 1)
			System.out.println("s");
		else
			System.out.println("");
		System.out.print(dime + " dime");
		if (dime != 1)
			System.out.println("s");
		else
			System.out.println("");
		System.out.print(nickels + " nickel");
		if (nickels != 1)
			System.out.println("s");
		else
			System.out.println("");
		if (pennies != 1)
			System.out.println(pennies + " pennies");
		else
			System.out.println(pennies + " penny");
	}

}
