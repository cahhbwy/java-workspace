package work8;

import java.awt.Color;
import javax.swing.JOptionPane;
import edu.princeton.cs.introcs.*;

public class Map {
	static int height, width;
	static double[] x = { -width, -width, width, width };
	static double[] y = { -height, height, height, -height };

	public static void draw(int i) {
		StdDraw.clear();
		StdDraw.setPenColor(Color.BLUE);
		StdDraw.filledSquare(0.0, 0, 50);
		StdDraw.picture(0, 0, "src/work8/bj.jpg");
		Food.drawFood();
		Snake.drawSnake();
		if (i == 1)
			StdDraw.setPenColor(Color.ORANGE);
		else
			StdDraw.setPenColor(Color.BLACK);
		StdDraw.setPenRadius(0.02);
		StdDraw.polygon(x, y);
		StdDraw.setPenRadius();
		
		StdDraw.setPenColor(Color.red);
		StdDraw.textLeft((double) -width, (double) height + 1, "score:"
				+ Food.result);
		StdDraw.text(0.0, (double) height + 1, "Grade:" + (Food.result / 10>25?25:Food.result / 10));

		if (Food.special.p != null)
			StdDraw.textRight((double) width, (double) height + 1, "time:"
					+ Food.special.score);
		// if(Food.grass.p!=null)
		// StdDraw.text(10.0, (double)height+1, "grass:"+Food.grass.score);
		StdDraw.setPenColor(Food.general.c);
		StdDraw.filledSquare(-width, height+2.3, 0.5);
		StdDraw.textLeft(0.5-width, height+2.3, "general");
		StdDraw.setPenColor(Food.special.c);
		StdDraw.filledSquare(-width/2, height+2.3, 0.5);
		StdDraw.textLeft(0.5-width/2, height+2.3, "special");
		StdDraw.setPenColor(Food.grass.c);
		StdDraw.filledSquare(0, height+2.3, 0.5);
		StdDraw.textLeft(0.5, height+2.3, "grass");
		StdDraw.setPenColor(Food.rock.c);
		StdDraw.filledSquare(width/2, height+2.3, 0.5);
		StdDraw.textLeft(0.5+width/2, height+2.3, "rock");
	}

	public static void drawmap() {
		width = Integer.parseInt(JOptionPane.showInputDialog(null,
				"输入窗口宽度：(10-60)")) / 2;
		height = Integer.parseInt(JOptionPane.showInputDialog(null,
				"输入窗口高度：(10-40)")) / 2;
		if (width >= 5 && width <= 30 && height >= 5 && height <= 20) {
			JOptionPane.showMessageDialog(null, "设置成功！" + width * 2 + "*"
					+ height * 2);
		} else {
			JOptionPane.showMessageDialog(null, "设置失败，使用默认值60*40");
			width = 30;
			height = 20;
		}
		JOptionPane.showMessageDialog(null, "黄色的是普通食物，一个五分，会使蛇身变长");
		JOptionPane.showMessageDialog(null,"红色是奖励食物，吃到的分数是倒计时所剩的时间");
		JOptionPane.showMessageDialog(null,"绿色是草，分数随机");
		JOptionPane.showMessageDialog(null,"黑色是岩石，撞上就结束啦");
		JOptionPane.showMessageDialog(null,"Are you ready???");
		x[0] = -width;
		x[1] = -width;
		x[2] = width;
		x[3] = width;
		y[0] = -height;
		y[1] = height;
		y[2] = height;
		y[3] = -height;
		int w =width* 600 /( height+1);
		int h = 600;
		StdDraw.setCanvasSize(w, h);
		StdDraw.setXscale(-width, width);
		StdDraw.setYscale(-height, height + 2);
	}
}
