package snake;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.Panel;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Ellipse2D;
import java.util.LinkedList;

import javax.net.ssl.SSLException;

import com.sun.corba.se.impl.oa.poa.ActiveObjectMap.Key;
import com.sun.webkit.dom.KeyboardEventImpl;

public class Map extends Panel implements KeyListener {
	int height = 40, width = 60;
	int level;
	Point origin;
	Point rock[];

	public Map(LayoutManager lm) {
		super(null);
		level = 1;
		rock = null;
	}

	public void paint2D(Graphics2D g) {
		drawGrid(g);
		drawInclosure(g);
		drawSnake(g);
		drawFood(g);
	}

	public void drawGrid(Graphics2D g) {
		g.setColor(Color.GREEN.darker());
		for (int i = 0; i <= 62; i++) {
			g.drawLine(i * 10, 0, i * 10, 470);
		}
		for (int i = 0; i <= 47; i++) {
			g.drawLine(0, i * 10, 620, i * 10);
		}
	}

	public void drawInclosure(Graphics2D g) {
		for (int i = -1; i < 61; i++) {
			drawSquare(g, i, -1, Color.ORANGE);
			drawSquare(g, i, 45, Color.ORANGE);
		}
		for (int i = -1; i < 46; i++) {
			drawSquare(g, -1, i, Color.ORANGE);
			drawSquare(g, 60, i, Color.ORANGE);
		}
	}

	public void drawSnake(Graphics2D g) {
		for (Snake snake : SnakeGUI.snakes) {
			LinkedList<Point> body = snake.body;
			for (int i = body.size() - 1; i > 0; i--) {
				drawCircle(g, body.get(i).x, body.get(i).y, snake.colorBody);
			}
			drawCircle(g, body.getFirst().x, body.getFirst().y, snake.colorHead);
		}
	}

	public void drawSquare(Graphics2D g, int x, int y, Color color) {
		int x0 = x * 10 + 11;
		int y0 = 451 - y * 10;
		g.setColor(color);
		g.fillRect(x0, y0, 9, 9);
	}

	public void drawCircle(Graphics2D g, int x, int y, Color color) {
		double xs = x * 10 + 8;
		double ys = 448 - y * 10;
		g.setColor(color);
		g.fill(new Ellipse2D.Double(xs, ys, 14, 14));
	}

	public void drawFood(Graphics2D g) {
		try {
			drawSquare(g, SnakeGUI.food.normal.x, SnakeGUI.food.normal.y, SnakeGUI.food.nmColor);
		} catch (NullPointerException e) {
		}
		try {
			drawSquare(g, SnakeGUI.food.random.x, SnakeGUI.food.random.y, SnakeGUI.food.rdColor);
		} catch (NullPointerException e) {
		}
		try {
			drawSquare(g, SnakeGUI.food.reward.x, SnakeGUI.food.reward.y, SnakeGUI.food.rwColor);
		} catch (NullPointerException e) {
		}
	}

	public void paint(Graphics g) {
		paint2D((Graphics2D) g);
	}

	Image ImageBuffer = null;
	Graphics GraImage = null;

	public void update(Graphics g) { // 覆盖update方法，截取默认的调用过程
		ImageBuffer = createImage(this.getWidth(), this.getHeight()); // 创建图形缓冲区
		GraImage = ImageBuffer.getGraphics(); // 获取图形缓冲区的图形上下文
		paint(GraImage); // 用paint方法中编写的绘图过程对图形缓冲区绘图
		GraImage.dispose(); // 释放图形上下文资源
		g.drawImage(ImageBuffer, 0, 0, this); // 将图形缓冲区绘制到屏幕上
	}

	public void keyPressed(KeyEvent eve) {
		if (eve.getKeyCode() == KeyEvent.VK_SPACE) {
			for (Snake snake : SnakeGUI.snakes) {
				snake.pause = !snake.pause;
			}
		}
		switch (SnakeGUI.snakes.length) {
			case 4:
				switch (eve.getKeyChar()) {
					case '4':
						SnakeGUI.snakes[3].setDire('l');
						break;
					case '6':
						SnakeGUI.snakes[3].setDire('r');
						break;
					case '8':
						SnakeGUI.snakes[3].setDire('u');
						break;
					case '5':
						SnakeGUI.snakes[3].setDire('d');
						break;
					default:
						break;
				}
			case 3:
				switch (eve.getKeyChar()) {
					case 'j':
						SnakeGUI.snakes[2].setDire('l');
						break;
					case 'l':
						SnakeGUI.snakes[2].setDire('r');
						break;
					case 'i':
						SnakeGUI.snakes[2].setDire('u');
						break;
					case 'k':
						SnakeGUI.snakes[2].setDire('d');
						break;
					default:
						break;
				}
			case 2:
				switch (eve.getKeyChar()) {
					case 'a':
						SnakeGUI.snakes[1].setDire('l');
						break;
					case 'd':
						SnakeGUI.snakes[1].setDire('r');
						break;
					case 'w':
						SnakeGUI.snakes[1].setDire('u');
						break;
					case 's':
						SnakeGUI.snakes[1].setDire('d');
						break;
					default:
						break;
				}
			case 1:
				switch (eve.getKeyCode()) {
					case KeyEvent.VK_LEFT:
						SnakeGUI.snakes[0].setDire('l');
						break;
					case KeyEvent.VK_RIGHT:
						SnakeGUI.snakes[0].setDire('r');
						break;
					case KeyEvent.VK_UP:
						SnakeGUI.snakes[0].setDire('u');
						break;
					case KeyEvent.VK_DOWN:
						SnakeGUI.snakes[0].setDire('d');
						break;
					default:
						break;
				}
				break;
			default:
				break;
		}
	}

	public void keyReleased(KeyEvent arg0) {
	}

	public void keyTyped(KeyEvent arg0) {
	}

}
