package russian;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;

public class Game extends Part {
	public Game() {
		board = new Board();
		part = new Part();
		part.newpt();
		StdDraw.show(10);
		part.show(pt, x, y);
		part.start();
		sleep.start();
	}

	public static void restart() {
		final Frame f = new Frame();
		Button b1 = new Button("结束");
		Button b2 = new Button("重来");
		f.setSize(300, 240);
		f.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 20));
		f.add(b1);
		f.add(b2);
		b1.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent eve) {
				f.setVisible(false);
				StdDraw.frame.setVisible(false);
				System.exit(0);
			}

			public void mouseEntered(MouseEvent e) {
			}

			public void mouseExited(MouseEvent e) {
			}

			public void mousePressed(MouseEvent e) {
			}

			public void mouseReleased(MouseEvent e) {
			}
		});
		b2.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent eve) {
				f.setVisible(false);
				new Game();
			}

			public void mouseEntered(MouseEvent e) {
			}

			public void mouseExited(MouseEvent e) {
			}

			public void mousePressed(MouseEvent e) {
			}

			public void mouseReleased(MouseEvent e) {
			}
		});
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent evt) {
				f.setVisible(false);
				f.dispose();
				System.exit(0);
			}
		});
		f.pack();
		f.setVisible(true);
	}

	public static void main(String[] args) {
		JOptionPane.showMessageDialog(null, "8456或wasd控制\n回车或空格暂停");
		new Game();
	}

}
