package chap12_2;

import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

@SuppressWarnings("serial")
public class KeyEventDemo extends Frame implements KeyListener {
	public KeyEventDemo() {
		super();
		init();
	}

	public static void main(String[] args) {
		new KeyEventDemo();
	}

	Button button;
	TextArea textarea, textarea1;

	public void init() {
		setLayout(new GridLayout(3, 1));
		textarea = new TextArea();
		textarea1 = new TextArea();
		add(textarea);
		button = new Button("���������ң�Ȼ�󵥻����̼�");
		add(button);
		button.addKeyListener(this);
		add(textarea1);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent evt) {
				setVisible(false);
				dispose();
				System.exit(0);
			}
		});
		setSize(200, 300);
		setVisible(true);
	}

	public void keyPressed(KeyEvent eve) {
		textarea.setText("���¼���");
	}

	public void keyReleased(KeyEvent eve) {
		textarea.setText("�ɿ�����");
	}

	public void keyTyped(KeyEvent eve) {
		textarea1.setText(String.valueOf(eve.getKeyChar()));
	}

}
