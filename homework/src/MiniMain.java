

public class MiniMain {
	public static void main(String[] args) {
		test1();
		test2();
	}
	
///*
	// Small, very simple test (Ant only).
	public static void test1() {
		System.out.println("Test 1 (Ant):");
		
		// create an Ant and move it 10 times
		Ant animal = new Ant(true);
		System.out.print(animal.toString() + " ");
		
		for (int i = 1; i <= 10; i++) {
			Critter.Direction move = animal.getMove();
			System.out.print(move + " " + animal.toString() + " ");
		}
		System.out.println();
		System.out.println();
	}
//*/	

///*
	// A bigger test (move several animals).  You can un-comment this
	// test (delete the /* and * /) once you implement the rest of the animals.
	// You'll also need to un-comment the call to test2 up in main.
	
	public static void test2() {
		System.out.println("Test 2 (all animals):");

		// Ant
		Ant ant1 = new Ant(true);
		Ant ant2 = new Ant(false);
		moves(ant1, 5);
		moves(ant2, 10);
		System.out.println();
		
		// Bird
		Bird bird1 = new Bird();
		Bird bird2 = new Bird();
		moves(bird1, 17);
		moves(bird2, 14);
		System.out.println();
		
		// Hippo (movement is random so may not match perfectly)
		Hippo hippo1 = new Hippo(4);
		Hippo hippo2 = new Hippo(0);
		moves(hippo1, 8);
		moves(hippo2, 12);
		eating(hippo1, 6);
		System.out.println();

		// Vulture
		Vulture vulture1 = new Vulture();
		Vulture vulture2 = new Vulture();
		moves(vulture1, 13);
		moves(vulture2, 8);
		System.out.println();
	}
//*/
	
	// Moves the given animal the given number of times and prints which
	// way the animal wanted to move each time.
	public static void moves(Critter critter, int times) {
		System.out.print(critter.getClass().getName() + " moving " + times + " times: ");
		System.out.print(critter.toString() + " ");
		for (int i = 1; i <= times; i++) {
			Critter.Direction move = critter.getMove();
			System.out.print(move + " ");
		}
		System.out.println(critter.toString());
	}
	
	// Asks the given animal if he wants to eat the given number of times
	// and prints whether the animal wanted to eat each time.
	public static void eating(Critter critter, int times) {
		System.out.print(critter.getClass().getName() + " eating " + times + " times: ");
		System.out.print(critter.toString() + " ");
		for (int i = 1; i <= times; i++) {
			boolean ate = critter.eat();
			System.out.print(ate + " " + critter.toString() + " ");
		}
		System.out.println();
	}
}
