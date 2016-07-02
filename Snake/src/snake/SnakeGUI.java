package snake;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class SnakeGUI extends Frame {

	MenuBar menuBar = new MenuBar();
	Menu game = new Menu("��Ϸ");
	MenuItem newGame = new MenuItem("����Ϸ");
	MenuItem openGame = new MenuItem("����Ϸ");
	MenuItem saveGame = new MenuItem("������Ϸ");
	MenuItem exitGame = new MenuItem("�˳���Ϸ");
	Menu operate = new Menu("����");
	MenuItem pause = new MenuItem("��ͣ");
	MenuItem settings = new MenuItem("����");
	MenuItem about = new MenuItem("����");

	Panel control = new Panel(null);
	Label scoreA = new Label("�÷�: ");
	TextField scoreB = new TextField('0');
	Button newGameBtn = new Button("����Ϸ");
	Button pauseBtn = new Button("��ͣ");
	Button settingsBtn = new Button("����");

	static Map map = new Map(null);

	int height = 45, width = 60;

	static Snake snakes[];
	static Food food;
	static int count;

	public SnakeGUI() {
		super("̰����");
		setLayout(null);
		setSize(824, 520);
		setVisible(true);
		setMenuBar(menuBar);
		menuBar.add(game);
		game.add(newGame);
		game.add(openGame);
		game.add(saveGame);
		game.addSeparator();
		game.add(exitGame);
		menuBar.add(operate);
		operate.add(pause);
		operate.add(settings);
		operate.addSeparator();
		operate.add(about);
		setResizable(false);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				setVisible(false);
				dispose();
				System.exit(0);
			}
		});

		control.setBounds(624, 46, 197, 471);
		control.setBackground(Color.GRAY);
		scoreA.setFont(new Font("����", Font.BOLD, 32));
		scoreA.setBounds(20, 15, 150, 50);
		control.add(scoreA);
		scoreB.setFont(new Font("����", Font.PLAIN, 28));
		scoreB.setEditable(false);
		scoreB.setBounds(20, 80, 150, 35);
		control.add(scoreB);
		newGameBtn.setFont(new Font("����", Font.PLAIN, 28));
		newGameBtn.setBounds(35, 150, 130, 70);
		control.add(newGameBtn);
		pauseBtn.setFont(new Font("����", Font.PLAIN, 28));
		pauseBtn.setBounds(35, 250, 130, 70);
		control.add(pauseBtn);
		settingsBtn.setFont(new Font("����", Font.PLAIN, 28));
		settingsBtn.setBounds(35, 350, 130, 70);
		control.add(settingsBtn);
		add(control);

		map.setBackground(Color.GREEN);
		map.setBounds(3, 46, 621, 471);
		add(map);

		snakes = new Snake[4];
		snakes[0] = new Snake(45, 60, -3);
		snakes[1] = new Snake(45, 60, -1);
		snakes[2] = new Snake(45, 60, +1);
		snakes[3] = new Snake(45, 60, +3);

		food = new Food();
		count = 0;
	}

	public static void main(String[] args) {
		SnakeGUI game = new SnakeGUI();
		for (Snake snake : snakes) {
			snake.start();
		}
		SnakeGUI.map.addKeyListener(SnakeGUI.map);
	}

}
