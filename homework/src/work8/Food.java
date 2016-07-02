package work8;

import java.awt.Color;
import java.awt.Point;

import work8.Snake.*;
import edu.princeton.cs.introcs.StdDraw;

public class Food {
	protected static int result = 0;
	protected static int num = 0;
	protected static int speed = 250;

	static class Node {
		Color c;
		Point p;
		int score;

		public Node(int i) {
			if (i == 1) {
				this.c = Color.YELLOW;
				this.p = null;
				this.score = 5;
			}
			if (i == 2) {
				this.c = Color.RED;
				this.p = null;
				this.score = 100;
			}
			if (i == 3) {
				this.c = Color.GREEN;
				this.p = null;
				this.score = (int) (100 * Math.random() - 50);
			}
			if (i == 4) {
				this.c = Color.BLACK;
				this.p = null;
				this.score = 0;
			}
		}
	}

	protected static Node general = new Food.Node(1);
	protected static Node special = new Food.Node(2);
	protected static Node grass = new Food.Node(3);
	protected static Node rock = new Food.Node(4);

	public static void setGeneralFood() {
		Food.general.p = Snake.head.p;
		Body temp = Snake.head;
		while (temp != null) {
			if (temp.p.equals(Food.general.p)) {
				Food.general.p = new Point(
						(int) ((Map.width - 1) * 2.0 * (Math.random() - 0.5)),
						(int) ((Map.height - 1) * 2.0 * (Math.random() - 0.5)));
				temp = Snake.head;
			} else
				temp = temp.next;
		}
	}

	private static void setSpecialFood() {
		Food.special.p = Snake.head.p;
		Food.special.score = 100;
		Body temp = Snake.head;
		while (temp != null) {
			if (temp.p.equals(Food.special.p)) {
				Food.special.p = new Point(
						(int) ((Map.width - 1) * 2 * (Math.random() - 0.5)),
						(int) ((Map.height - 1) * 2 * (Math.random() - 0.5)));
				temp = Snake.head;
			} else
				temp = temp.next;
		}
		StdDraw.setPenColor(Food.special.c);
		StdDraw.filledSquare(Food.special.p.x, Food.special.p.y, 0.5);
	}

	private static void setGrassFood() {
		Food.grass.p = Snake.head.p;
		Food.grass.score = (int) (100 * Math.random() - 50);
		Body temp = Snake.head;
		while (temp != null) {
			if (temp.p.equals(Food.grass.p)) {
				Food.grass.p = new Point(
						(int) ((Map.width - 1) * 2 * (Math.random() - 0.5)),
						(int) ((Map.height - 1) * 2 * (Math.random() - 0.5)));
				temp = Snake.head;
			} else
				temp = temp.next;
		}
	}

	private static void setRockFood() {
		Food.rock.p = Snake.head.p;
		Body temp = Snake.head;
		while (temp != null) {
			if (temp.p.equals(Food.rock.p) || temp.p.equals(general.p)) {
				Food.rock.p = new Point(
						(int) ((Map.width - 1) * 2 * (Math.random() - 0.5)),
						(int) ((Map.height - 1) * 2 * (Math.random() - 0.5)));
				temp = Snake.head;
			} else
				temp = temp.next;
		}
	}

	public static void drawFood() {
		StdDraw.setPenColor(Food.general.c);
		StdDraw.filledSquare(Food.general.p.x, Food.general.p.y, 0.5);
		if (Food.special.p != null) {
			StdDraw.setPenColor(Food.special.c);
			StdDraw.filledCircle(Food.special.p.x, Food.special.p.y, 0.5);
		}
		if (Food.grass.p != null) {
			StdDraw.setPenColor(Food.grass.c);
			StdDraw.filledCircle(Food.grass.p.x, Food.grass.p.y, 0.5);
		}
		if (Food.rock.p != null) {
			StdDraw.setPenColor(Food.rock.c);
			StdDraw.filledSquare(Food.rock.p.x, Food.rock.p.y, 0.5);
		}
	}

	public static void eatFood() {
		if (Snake.head.p.equals(Food.general.p)) {
			Snake.Body temp = new Snake.Body();
			temp.p = new Point(Snake.tail.p.x, Snake.tail.p.y);
			temp.last = Snake.tail;
			Snake.tail.next = temp;
			Snake.tail = temp;
			result += Food.general.score;
			num++;
			setGeneralFood();
			if (num % 5 == 0)
				setSpecialFood();
			if (num % 3 == 0)
				setGrassFood();
			if (num % 2 == 0)
				setRockFood();
		}
		if (Snake.head.p.equals(Food.special.p)) {
			result += Food.special.score;
			Food.special.p = null;
		}
		if (Food.special.p != null) {
			Food.special.score--;
			if (Food.special.score == 0) {
				Food.special.p = null;
			}
		}
		if (Snake.head.p.equals(Food.grass.p)) {
			result += Food.grass.score;
			Food.grass.p = null;
		}
		speed = 250 - result >50?250 - result :50;
	}

}
