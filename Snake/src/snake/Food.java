package snake;

import java.awt.Color;
import java.awt.Point;
import java.util.Random;

public class Food {

	Point normal, random, reward;
	Color nmColor, rdColor, rwColor;
	int nmScore, rdScore, rwScore;
	Random r;

	public Food() {
		this.r = new Random();
		this.nmColor = Color.YELLOW;
		this.rdColor = Color.BLUE;
		this.rwColor = Color.RED;
		this.nmScore = 5;
		this.rdScore = r.nextInt(100) - 50;
		this.rwScore = 100;
	}

	public void nextFoodRandom() {
		Point p;
		do {
			p = new Point(r.nextInt(60), r.nextInt(45));
		} while (isEmpty(p));
		random = p;
	}

	public void nextFoodReward() {
		Point p;
		do {
			p = new Point(r.nextInt(60), r.nextInt(45));
		} while (isEmpty(p));
		reward = p;
	}

	public void nextFoodNormal() {
		Point p;
		do {
			p = new Point(r.nextInt(60), r.nextInt(45));
		} while (isEmpty(p));
		normal = p;

	}

	public boolean isEmpty(Point p) {
		try {
			for (Point test : SnakeGUI.map.rock) {
				if (p.equals(test)) {
					return false;
				}
			}
		} catch (NullPointerException e) {
		}
		for (Snake snake : SnakeGUI.snakes) {
			for (Point test : snake.body) {
				if (p.equals(test)) {
					return false;
				}
			}
		}
		if (p.equals(normal) || p.equals(random) || p.equals(reward)) {
			return false;
		}
		return true;
	}

}
