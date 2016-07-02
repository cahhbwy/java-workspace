package snake;

import java.awt.Color;
import java.awt.Point;
import java.util.LinkedList;
import java.util.Random;

public class Snake extends Thread {

	LinkedList<Point> body;
	Color colorHead, colorBody;
	char director;
	int score;
	int speed;
	boolean life;
	boolean pause;

	int height, width;

	public Snake(int height, int width, int offset) {
		this.height = height;
		this.width = width;
		this.director = 'l';
		this.score = 0;
		this.speed = 1000;
		this.life = true;
		this.pause = false;
		Random random = new Random();
		colorHead = new Color(random.nextInt());
		colorBody = new Color(random.nextInt());
		body = new LinkedList<>();
		body.add(new Point(width / 2 - 1, height / 2 + offset));
		body.add(new Point(width / 2, height / 2 + offset));
		body.add(new Point(width / 2 + 1, height / 2 + offset));
	}

	public void setDire(char dire) {
		if (body.getFirst().x == body.get(1).x) {
			if (dire == 'l' || dire == 'r')
				director = dire;
		} else {
			if (dire == 'u' || dire == 'd')
				director = dire;
		}
	}

	public void oneStep() {
		while (life) {
			try {
				sleep(speed);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (pause)
				continue;
			switch (director) {
				case 'l':
					body.addFirst(new Point((body.getFirst().x + width - 1) % width, body.getFirst().y));
					body.removeLast();
					break;
				case 'r':
					body.addFirst(new Point((body.getFirst().x + 1) % width, body.getFirst().y));
					body.removeLast();
					break;
				case 'u':
					body.addFirst(new Point(body.getFirst().x, (body.getFirst().y + 1) % height));
					body.removeLast();
					break;
				case 'd':
					body.addFirst(new Point(body.getFirst().x, (body.getFirst().y + height - 1) % height));
					body.removeLast();
					break;
				default:
					break;
			}
			synchronized (SnakeGUI.map) {
				SnakeGUI.map.update(SnakeGUI.map.getGraphics());
			}
			synchronized (SnakeGUI.food) {
				if (body.getFirst().equals(SnakeGUI.food.normal)) {
					score += SnakeGUI.food.nmScore;
					SnakeGUI.food.nextFoodNormal();
					SnakeGUI.count++;
				} else if (body.getFirst().equals(SnakeGUI.food.random)) {
					score += SnakeGUI.food.rdScore;
				} else if (body.getFirst().equals(SnakeGUI.food.reward)) {
					score += SnakeGUI.food.rwScore;
				} else if (isHit(body.getFirst())) {
					life = false;
				}
				if (SnakeGUI.count % 3 == 0) {
					SnakeGUI.food.nextFoodRandom();
				}
				if (SnakeGUI.count % 7 == 0) {
					SnakeGUI.food.nextFoodReward();
				}
			}
		}
	}

	public boolean isHit(Point p) {
		for (Snake snake : SnakeGUI.snakes) {
			for (Point test : snake.body) {
				if (p.equals(test)) {
					return true;
				}
			}
		}
		for (Point test : SnakeGUI.map.rock) {
			if (p.equals(test)) {
				return true;
			}
		}
		return false;
	}

	public void run() {
		oneStep();
	}

}
