package work6;

import edu.princeton.cs.introcs.StdOut;

public class Tour {
	private int num = 0;
	private Node head = null;
	private Node last = head;

	private class Node {
		private Point p;
		private Node next;
	}

	Tour() { // create an empty tour
		last = head = new Node();
	}

	Tour(Point a, Point b, Point c, Point d) { // create a 4 point tour
												// a->b->c->d->a
		head = new Node();
		Node t1 = new Node();
		Node t2 = new Node();
		Node t3 = new Node();
		head.p = a;
		t1.p = b;
		t2.p = c;
		t3.p = d;
		head.next = t1;
		t1.next = t2;
		t2.next = t3;
		t3.next = head;
	}

	void show() { // print the tour to standard output
		Node temp = head;
		do {
			StdOut.println(temp.p.toString());
			temp = temp.next;
		} while (temp != head);
	}

	void draw() { // draw the tour to standard draw
		Node temp = head;
		do {
			temp.p.drawTo(temp.next.p);
			temp = temp.next;
		} while (temp != head);
	}

	int size() {
		return num; // number of points on tour
	}

	double distance() {
		Node temp = head;
		double distance = 0.0;
		do {
			distance += temp.p.distanceTo(temp.next.p);
			temp = temp.next;
		} while (temp != head);
		return distance; // return the total distance of the tour
	}

	void insertNearest(Point p) { // insert p using nearest neighbor heuristic
		if (head.p == null) {
			head.p = p;
			head.next = head;
		} else {
			Node nextpoint = new Node();
			nextpoint.p = p;
			Node temp1 = head, temp = head;
			double minDistance = p.distanceTo(temp1.p);
			do {
				if (minDistance > p.distanceTo(temp1.p)) {
					minDistance = p.distanceTo(temp1.p);
					temp = temp1;
				}
				temp1 = temp1.next;
			} while (temp1 != head);
			nextpoint.next = temp.next;
			temp.next = nextpoint;
		}
		num++;
	}

	void insertSmallest(Point p) { // insert p using smallest increase heuristic
		if (head.p == null) {
			head.p = p;
			head.next = head;
		} else {
			Node nextpoint = new Node();
			nextpoint.p = p;
			Node temp1 = head, temp = head;
			double minDistance = p.distanceTo(temp1.p)
					+ p.distanceTo(temp1.next.p)
					- temp1.p.distanceTo(temp1.next.p);
			do {
				if (minDistance > p.distanceTo(temp1.p)
						+ p.distanceTo(temp1.next.p)
						- temp1.p.distanceTo(temp1.next.p)) {
					minDistance = p.distanceTo(temp1.p)
							+ p.distanceTo(temp1.next.p)
							- temp1.p.distanceTo(temp1.next.p);
					temp = temp1;
				}
				temp1 = temp1.next;
			} while (temp1 != head);
			nextpoint.next = temp.next;
			temp.next = nextpoint;
		}
		num++;
	}

	void insertInOrder(Point p) {
		if (head.p == null) {
			head.p = p;
			head.next = head;
		} else {
			Node nextPoint = new Node();
			nextPoint.p = p;
			last.next = nextPoint;
			last = nextPoint;
			nextPoint.next = head;
		}
	}

	// main method for testing
	public static void main(String[] args) {
		// define 4 points forming a square

		Point a = new Point(100.0, 100.0);
		Point b = new Point(500.0, 100.0);
		Point c = new Point(500.0, 500.0);
		Point d = new Point(100.0, 500.0);

		// Set up a Tour with those four points
		// The constructor should link a->b->c->d->a
		Tour squareTour = new Tour(a, b, c, d);

		// Output the Tour
		squareTour.show();
	}

}
