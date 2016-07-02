package gobang;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.io.*;
import javax.swing.*;

public class GobangGUI extends Frame
		implements ActionListener, ItemListener, AdjustmentListener, MouseListener, MouseMotionListener {
	private static final long serialVersionUID = 1L;
	Graphics g;
	String fileName = "GobangSave.txt";
	// program
	int size = 15, halfsize = 7;
	boolean player = true;
	GobangCore gobangCore = new GobangCore(size, player);
	boolean running;

	MenuBar menuBar = new MenuBar();
	Menu game = new Menu("游戏");
	MenuItem newGame = new MenuItem("新游戏");
	MenuItem openGame = new MenuItem("打开游戏");
	MenuItem saveGame = new MenuItem("保存游戏");
	MenuItem exitGame = new MenuItem("退出");
	Menu operate = new Menu("操作");
	MenuItem prompt = new MenuItem("提示");
	MenuItem back = new MenuItem("悔棋");
	MenuItem settings = new MenuItem("设置");
	PanelDraw board = new PanelDraw(null);
	Panel ctrl = new Panel(null);
	Button newGBtn = new Button("新游戏");
	Button helpBtn = new Button("提示");
	Button backBtn = new Button("悔棋");
	Point selectMe = new Point();
	Point selectAI = new Point(halfsize, halfsize);
	Point selectHP = new Point();
	int hasHP;

	Frame settingFrame = new Frame("设置");
	CheckboxGroup orderCbg = new CheckboxGroup();
	Checkbox firstCb = new Checkbox("先手", true, orderCbg);
	Checkbox lastCb = new Checkbox("后手", false, orderCbg);
	Scrollbar sizeSb = new Scrollbar(Scrollbar.HORIZONTAL, 6, 2, 5, 18);
	Label sizeLbl = new Label("棋盘大小:");
	TextField sizeTf = new TextField("15", 3);
	Button configureBtn = new Button("确认");
	Button cancelBtn = new Button("取消");
	boolean playerTmp = true;
	int sizeTmp = 15;

	public GobangGUI() {
		super("Gobang");
		running = true;
		hasHP = 4;
		initGUI();
	}

	public static void main(String[] args) {
		new GobangGUI();
	}

	private void initGUI() {
		game.add(newGame);
		game.add(openGame);
		game.add(saveGame);
		game.addSeparator();
		game.add(exitGame);
		operate.add(prompt);
		operate.add(back);
		operate.addSeparator();
		operate.add(settings);
		menuBar.add(game);
		menuBar.add(operate);
		setMenuBar(menuBar);
		setLayout(null);
		setSize(706, 548);
		board.setBounds(3, 45, 500, 500);
		board.setBackground(Color.lightGray);
		ctrl.setBounds(503, 45, 200, 500);
		ctrl.setBackground(Color.GRAY);
		board.setSize(500, 500);
		ctrl.setSize(200, 500);
		ctrl.setLayout(null);
		newGBtn.setBounds(40, 100, 120, 60);
		ctrl.add(newGBtn);
		helpBtn.setBounds(40, 200, 120, 60);
		ctrl.add(helpBtn);
		backBtn.setBounds(40, 300, 120, 60);
		ctrl.add(backBtn);
		add(board);
		add(ctrl);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				setVisible(false);
				dispose();
				System.exit(0);
			}
		});
		setResizable(false);
		setVisible(true);
		newGame.addActionListener(this);
		openGame.addActionListener(this);
		saveGame.addActionListener(this);
		exitGame.addActionListener(this);
		prompt.addActionListener(this);
		back.addActionListener(this);
		settings.addActionListener(this);
		newGBtn.addActionListener(this);
		helpBtn.addActionListener(this);
		backBtn.addActionListener(this);
		board.addMouseListener(this);
		board.addMouseMotionListener(this);

		settingFrame.setSize(200, 180);
		settingFrame.setLayout(null);
		firstCb.setBounds(40, 50, 60, 20);
		settingFrame.add(firstCb);
		lastCb.setBounds(100, 50, 60, 20);
		settingFrame.add(lastCb);
		sizeSb.setBounds(20, 80, 160, 20);
		settingFrame.add(sizeSb);
		sizeLbl.setBounds(40, 110, 60, 20);
		settingFrame.add(sizeLbl);
		sizeTf.setEditable(false);
		sizeTf.setBounds(100, 110, 60, 20);
		settingFrame.add(sizeTf);
		configureBtn.setBounds(50, 140, 40, 25);
		settingFrame.add(configureBtn);
		cancelBtn.setBounds(110, 140, 40, 25);
		settingFrame.add(cancelBtn);
		settingFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				settingFrame.setVisible(false);
				settingFrame.dispose();
			}
		});
		settingFrame.setResizable(false);
		settingFrame.setVisible(false);
		firstCb.addItemListener(this);
		lastCb.addItemListener(this);
		sizeSb.addAdjustmentListener(this);
		configureBtn.addActionListener(this);
		cancelBtn.addActionListener(this);
	}

	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == newGame || event.getSource() == newGBtn) {
			gobangCore = new GobangCore(size, player);
			running = true;
			hasHP = 4;
			saveGame.setEnabled(true);
			board.update(board.getGraphics());
		} else if (event.getSource() == openGame) {
			try {
				gobangCore = new GobangCore(fileName);
				hasHP = 4;
				this.size = gobangCore.size;
				this.halfsize = size / 2;
				this.player = gobangCore.player;
				this.selectAI.x = halfsize;
				this.selectAI.y = halfsize;
				this.board.init();
				this.running = true;
				saveGame.setEnabled(true);
				if (!player) {
					selectAI = gobangCore.computer(true);
					gobangCore.setInput(selectAI.x, selectAI.y);
					board.update(board.getGraphics());
				}
				board.update(board.getGraphics());
			} catch (FileNotFoundException e) {
				JOptionPane.showMessageDialog(null, "无保存记录");
				e.printStackTrace();
			}
		} else if (event.getSource() == saveGame) {
			try {
				gobangCore.save(fileName);
			} catch (FileNotFoundException e) {
				JOptionPane.showMessageDialog(null, "保存失败");
				e.printStackTrace();
			}
		} else if (event.getSource() == exitGame) {
			setVisible(false);
			dispose();
			System.exit(0);
		} else if (event.getSource() == prompt || event.getSource() == helpBtn) {
			if (!running)
				return;
			selectHP = gobangCore.computer(false);
			hasHP = 3;
			board.update(board.getGraphics());
		} else if (event.getSource() == back || event.getSource() == backBtn) {
			selectAI = gobangCore.back();
			if (selectAI == null) {
				selectAI = new Point(halfsize, halfsize);
			}
			running = true;
			saveGame.setEnabled(true);
			hasHP = 4;
			board.update(board.getGraphics());
		} else if (event.getSource() == settings) {
			hasHP = 4;
			settingFrame.setVisible(true);
		} else if (event.getSource() == configureBtn) {
			this.size = sizeTmp;
			this.halfsize = sizeTmp / 2;
			this.player = playerTmp;
			this.selectAI.x = halfsize;
			this.selectAI.y = halfsize;
			this.board.init();
			this.running = true;
			saveGame.setEnabled(true);
			gobangCore = new GobangCore(sizeTmp, playerTmp);
			if (!player) {
				selectAI = gobangCore.computer(true);
				gobangCore.setInput(selectAI.x, selectAI.y);
				board.update(board.getGraphics());
			}
			board.update(board.getGraphics());
			settingFrame.setVisible(false);
			settingFrame.dispose();
		} else if (event.getSource() == cancelBtn) {
			settingFrame.setVisible(false);
			settingFrame.dispose();
		}
	}

	public void itemStateChanged(ItemEvent event) {
		if (event.getSource() == firstCb) {
			playerTmp = true;
		} else if (event.getSource() == lastCb) {
			playerTmp = false;
		}
	}

	public void adjustmentValueChanged(AdjustmentEvent event) {
		if (event.getSource() == sizeSb) {
			sizeTf.setText(Integer.toString(((Scrollbar) event.getSource()).getValue() * 2 + 1));
			sizeTmp = ((Scrollbar) event.getSource()).getValue() * 2 + 1;
		}
	}

	public void mouseClicked(MouseEvent event) {
		hasHP = 4;
		if (!running)
			return;
		selectMe.x = (event.getX() - board.head + board.step / 2) / board.step;
		selectMe.x = selectMe.x < 0 ? 0 : selectMe.x;
		selectMe.x = selectMe.x >= size ? size - 1 : selectMe.x;
		selectMe.y = (event.getY() - board.head + board.step / 2) / board.step;
		selectMe.y = selectMe.y < 0 ? 0 : selectMe.y;
		selectMe.y = selectMe.y >= size ? size - 1 : selectMe.y;
		if (gobangCore.setInput(selectMe.x, selectMe.y)) {
			board.update(board.getGraphics());
			if (gobangCore.number <= 0) {
				JOptionPane.showMessageDialog(null, "居然是平局！");
				JOptionPane.showMessageDialog(null, "*******Little Monk*******");
				JOptionPane.showMessageDialog(null, "https://github.com/cahhbwy/Gobang.git");
				saveGame.setEnabled(false);
				running = false;
				return;
			}
			if (gobangCore.check(selectMe.x, selectMe.y)) {
				JOptionPane.showMessageDialog(null, "恭喜恭喜，你胜利啦！");
				saveGame.setEnabled(false);
				running = false;
				return;
			}
			selectAI = gobangCore.computer(true);
			gobangCore.setInput(selectAI.x, selectAI.y);
			board.update(board.getGraphics());
			if (gobangCore.check(selectAI.x, selectAI.y)) {
				JOptionPane.showMessageDialog(null, "不要灰心，再来一次！");
				saveGame.setEnabled(false);
				running = false;
			}
		}
	}

	public void mousePressed(MouseEvent event) {
	}

	public void mouseReleased(MouseEvent event) {
	}

	public void mouseEntered(MouseEvent event) {
	}

	public void mouseExited(MouseEvent event) {
	}

	public void mouseDragged(MouseEvent event) {
	}

	public void mouseMoved(MouseEvent event) {
		int x = selectMe.x, y = selectMe.y;
		selectMe.x = (event.getX() - board.head + board.step / 2) / board.step;
		selectMe.x = selectMe.x < 0 ? 0 : selectMe.x;
		selectMe.x = selectMe.x >= size ? size - 1 : selectMe.x;
		selectMe.y = (event.getY() - board.head + board.step / 2) / board.step;
		selectMe.y = selectMe.y < 0 ? 0 : selectMe.y;
		selectMe.y = selectMe.y >= size ? size - 1 : selectMe.y;
		if (x != selectMe.x || y != selectMe.y) {
			board.update(board.getGraphics());
		}
	}

	class PanelDraw extends Panel {
		private static final long serialVersionUID = -3942092599847638278L;
		int step;
		int head, tail;

		public PanelDraw(BorderLayout Layout) {
			super(null);
			init();
		}

		public void init() {
			step = 500 / (size + 2);
			head = (500 - (size - 1) * step) / 2;
			tail = head + (size - 1) * step;
		}

		public void paint2D(Graphics2D g) {
			for (int i = 0; i < size; i++) {
				g.drawLine(head, head + i * step, tail, head + i * step);
				g.drawLine(head + i * step, head, head + i * step, tail);
			}
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					if (gobangCore.chess[i][j] == 1) {
						drawChess(g, head + i * step, head + j * step, step / 2.2, true);
					} else if (gobangCore.chess[i][j] == 2) {
						drawChess(g, head + i * step, head + j * step, step / 2.2, false);
					} else {
						continue;
					}
				}
			}
			drawSelect(g, head + selectMe.x * step, head + selectMe.y * step, step / 2, 1);
			drawSelect(g, head + selectAI.x * step, head + selectAI.y * step, step / 2, 2);
			drawSelect(g, head + selectHP.x * step, head + selectHP.y * step, step / 2, hasHP);
		}

		private void drawChess(Graphics2D g, int x, int y, double r, boolean player) {
			double xs = x - r;
			double ys = y - r;
			if (player) {
				g.fill(new Ellipse2D.Double(xs, ys, 2 * r, 2 * r));
			} else {
				g.setColor(Color.WHITE);
				g.fill(new Ellipse2D.Double(xs, ys, 2 * r, 2 * r));
				g.setColor(Color.BLACK);
			}
		}

		private void drawSelect(Graphics2D g, int x, int y, int r, int i) {
			int xs = x - r;
			int ys = y - r;
			switch (i) {
				case 1:
					g.setColor(Color.RED);
					break;
				case 2:
					g.setColor(Color.BLUE);
					break;
				case 3:
					g.setColor(Color.MAGENTA);
					break;
				default:
					return;
			}
			g.drawRect(xs, ys, 2 * r, 2 * r);
			g.setColor(Color.BLACK);
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
	}

}
