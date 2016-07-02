package work8;

import java.awt.*;

import edu.princeton.cs.introcs.*;

public class Snake {
	protected char direction = 'l';
	protected static Body head = null;
	protected static Body tail = null;
	protected static boolean life = true;

	protected static class Body {
		Point p;
		Color c;
		Body last;
		Body next;

		public Body() {
			this.c = Color.CYAN;
		}
	}

	private static void draw(Body temp) {
		StdDraw.setPenColor(temp.c);
		StdDraw.filledCircle(temp.p.x, temp.p.y, 0.6);
	}

	Snake() {
		head = new Body();
		head.c = Color.blue;
		head.p = new Point(-1, 0);
		head.next = new Body();
		head.next.p = new Point(0, 0);
		head.next.next = new Body();
		head.next.next.p = new Point(1, 0);
		tail = head;
		while (tail.next != null) {
			tail.next.last = tail;
			tail = tail.next;
		}
	}

	public static void drawSnake() {
		Body temp = head;
		do {
			draw(temp);
			temp = temp.next;
		} while (temp != null);
	}

	public boolean alive(int i) {
		Body temp = head.next;
		do {
			if (head.p.equals(temp.p)) {
				life = false;
				return life;
			}
			temp = temp.next;
		} while (temp != null);
		if (i == 2) {
			if (head.p.x >= Map.width || head.p.x <= -Map.width
					|| head.p.y >= Map.height || head.p.y <= -Map.height) {
				life = false;
				return life;
			}
		}
		if (Snake.head.p.equals(Food.rock.p))
			Snake.life = false;
		return life;
	}

	public void move(char in, int i) {
		if (direction == 'u' || direction == 'd') {
			if (in == 'l') {
				moveleft(i);
				return;
			}
			if (in == 'r') {
				moveright(i);
				return;
			}
			movestill(i);
			return;
		} else {
			if (in == 'u') {
				moveup(i);
				return;
			}
			if (in == 'd') {
				movedown(i);
				return;
			}
			movestill(i);
			return;
		}
	}

	private void moveup(int i) {
		Body temp = tail;
		while (temp != head) {
			temp.p = temp.last.p;
			temp = temp.last;
		}
		if (head.next.p.y + 1 >= Map.height && i == 1)
			head.p = new Point(head.next.p.x, -Map.height + 1);
		else
			head.p = new Point(head.next.p.x, head.next.p.y + 1);
		direction = 'u';
		return;
	}

	private void movedown(int i) {
		Body temp = tail;
		while (temp != head) {
			temp.p = temp.last.p;
			temp = temp.last;
		}
		if (head.next.p.y - 1 <= -Map.height && i == 1)
			head.p = new Point(head.next.p.x, Map.height - 1);
		else
			head.p = new Point(head.next.p.x, head.next.p.y - 1);
		direction = 'd';
		return;
	}

	private void moveleft(int i) {
		Body temp = tail;
		while (temp != head) {
			temp.p = temp.last.p;
			temp = temp.last;
		}
		if (head.next.p.x - 1 <= -Map.width && i == 1)
			head.p = new Point(Map.width - 1, head.next.p.y);
		else
			head.p = new Point(head.next.p.x - 1, head.next.p.y);
		direction = 'l';
		return;
	}

	private void moveright(int i) {
		Body temp = tail;
		while (temp != head) {
			temp.p = temp.last.p;
			temp = temp.last;
		}
		if (head.next.p.x + 1 >= Map.width && i == 1)
			head.p = new Point(-Map.width + 1, head.next.p.y);
		else
			head.p = new Point(head.next.p.x + 1, head.next.p.y);
		direction = 'r';
		return;
	}

	private void movestill(int i) {
		switch (direction) {
		case 'u':
			moveup(i);
			return;
		case 'd':
			movedown(i);
			return;
		case 'l':
			moveleft(i);
			return;
		case 'r':
			moveright(i);
			return;
		}
	}

	public static void sleep(int i) {
		StdDraw.show(i);
	}

}
