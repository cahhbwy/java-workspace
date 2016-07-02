package work8;

import javax.swing.JOptionPane;

import edu.princeton.cs.introcs.*;

public class Game {
	public static void main(String[] args) {
		int choice;
		while (true) {
			choice = Integer.parseInt(JOptionPane.showInputDialog(null,
					"选择是否可以穿墙？1.可以；2.不可以"));
			if (choice == 1 || choice == 2)
				break;
		}
		Map.drawmap();
		Snake snake = new Snake();
		Snake.drawSnake();
		Food.setGeneralFood();
		while (snake.alive(choice)) {
			char in = 'n';
			if (StdDraw.hasNextKeyTyped()) {
				switch (StdDraw.nextKeyTyped()) {
				case 'w':case '8':in = 'u';break;
				case 'a':case '4':in = 'l';break;
				case 's':case '5':in = 'd';break;
				case 'd':case '6':in = 'r';break;
				default:in = 'n';break;
				}
			}
			Food.eatFood();
			snake.move(in, choice);
			Map.draw(choice);
			Snake.sleep(Food.speed);
		}
		StdDraw.show(1000);
		StdDraw.show();
		StdDraw.clear();
		StdDraw.text(0, 2, "Your score is " + Food.result);
		StdDraw.show();
	}

}
