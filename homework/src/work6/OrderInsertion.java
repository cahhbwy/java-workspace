package work6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import edu.princeton.cs.introcs.*;

/*************************************************************************
 * YOU DO NOT NEED TO MODIFY THIS FILE
 * 
 * Compilation: javac OrderInsertion.java Execution: java OrderInsertion <
 * file.txt Dependencies: Tour.java Point.java StdIn.java StdDraw.java
 * 
 * Run order of input insertion heuristic for traveling salesperson problem and
 * plot results.
 * 
 * % java OrderInsertion < tsp10.txt
 * 
 *************************************************************************/

public class OrderInsertion {
	private static Scanner reader;

	public static void main(String[] args) {
		try {
			reader = new Scanner(new File("src/work6/tsp/tsp1000.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		// get dimensions
		int w = reader.nextInt();
		int h = reader.nextInt();

		StdDraw.setCanvasSize(w, h);
		StdDraw.setXscale(0, w);
		StdDraw.setYscale(0, h);

		// turn on animation mode
		StdDraw.show(0);

		// run smallest insertion heuristic
		Tour tour = new Tour();
		while (reader.hasNextDouble()) {
			double x = reader.nextDouble();
			double y = reader.nextDouble();
			Point p = new Point(x, y);
			tour.insertInOrder(p);

			// uncomment the 4 lines below to animate
			// StdDraw.clear();
			// tour.draw();
			// StdDraw.text(100, 0, "" + tour.distance());
			// StdDraw.show(50);
		}

		// draw to standard draw
		tour.draw();
		StdDraw.show(0);

		// print tour to standard output
		StdOut.printf("Tour distance =  %.4f\n", tour.distance());
		StdOut.printf("Number of points = %d\n", tour.size());
		tour.show();
	}

}
