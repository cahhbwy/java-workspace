package homework3;

import java.awt.*;
import java.awt.datatransfer.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class TextEditer extends Frame implements ActionListener {
	static TextEditer frame;
	static JTextArea textArea = new JTextArea();
	static Font font = new Font("宋体", Font.PLAIN, 16);
	static Color ysColor = Color.BLACK;
	static Color dsColor = Color.WHITE;
	MenuBar menuBar;
	Menu fileMenu;
	MenuItem newItem;
	MenuItem openItem;
	MenuItem saveItem;
	MenuItem saveAsItem;
	MenuItem exitItem;
	Menu editMenu;
	MenuItem selectItem;
	MenuItem copyItem;
	MenuItem cutItem;
	MenuItem pasteItem;
	MenuItem formatItem;
	String fileName = "未命名.txt";
	Toolkit toolkit = Toolkit.getDefaultToolkit();
	Clipboard clipboard = toolkit.getSystemClipboard();
	private FileDialog openFileDialog = new FileDialog(this, "打开", FileDialog.LOAD);
	private FileDialog saveAsFileDialog = new FileDialog(this, "另存为", FileDialog.SAVE);

	public TextEditer() {
		menuBar = new MenuBar();
		fileMenu = new Menu("文件");
		newItem = new MenuItem("新建");
		openItem = new MenuItem("打开");
		saveItem = new MenuItem("保存");
		saveAsItem = new MenuItem("另存为");
		exitItem = new MenuItem("退出");
		editMenu = new Menu("编辑");
		selectItem = new MenuItem("全选");
		copyItem = new MenuItem("复制");
		cutItem = new MenuItem("剪切");
		pasteItem = new MenuItem("粘贴");
		formatItem = new MenuItem("字体格式");
		setTitle("TextEditer");
		setBackground(Color.white);
		setSize(600, 400);
		fileMenu.add(newItem);
		fileMenu.add(openItem);
		fileMenu.addSeparator();
		fileMenu.add(saveItem);
		fileMenu.add(saveAsItem);
		fileMenu.addSeparator();
		fileMenu.add(exitItem);
		editMenu.add(selectItem);
		editMenu.addSeparator();
		editMenu.add(copyItem);
		editMenu.add(cutItem);
		editMenu.add(pasteItem);
		editMenu.addSeparator();
		editMenu.add(formatItem);
		menuBar.add(fileMenu);
		menuBar.add(editMenu);
		setMenuBar(menuBar);
		add(textArea);
		textArea.setLineWrap(true);
		add(new JScrollPane(textArea));
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		newItem.addActionListener(this);
		openItem.addActionListener(this);
		saveItem.addActionListener(this);
		saveAsItem.addActionListener(this);
		exitItem.addActionListener(this);
		selectItem.addActionListener(this);
		copyItem.addActionListener(this);
		cutItem.addActionListener(this);
		pasteItem.addActionListener(this);
		formatItem.addActionListener(this);
		textArea.setFont(font);
		textArea.setBackground(dsColor);
		textArea.setForeground(ysColor);
	}

	public void actionPerformed(ActionEvent e) {
		Object eventSource = e.getSource();
		if (eventSource == newItem) {
			textArea.setText("");
		} else if (eventSource == openItem) {
			openFileDialog.setVisible(true);
			fileName = openFileDialog.getDirectory() + openFileDialog.getFile();
			if (fileName != null)
				readFile(fileName);
		} else if (eventSource == saveItem) {
			if (fileName != null)
				writeFile(fileName);
		} else if (eventSource == saveAsItem) {
			saveAsFileDialog.setVisible(true);
			fileName = saveAsFileDialog.getDirectory() + saveAsFileDialog.getFile();
			if (fileName != null)
				writeFile(fileName);
		} else if (eventSource == selectItem) {
			textArea.selectAll();
		} else if (eventSource == copyItem) {
			String text = textArea.getSelectedText();
			StringSelection selection = new StringSelection(text);
			clipboard.setContents(selection, null);
		} else if (eventSource == cutItem) {
			String text = textArea.getSelectedText();
			StringSelection selection = new StringSelection(text);
			clipboard.setContents(selection, null);
			textArea.replaceRange("", textArea.getSelectionStart(), textArea.getSelectionEnd());
		} else if (eventSource == pasteItem) {
			Transferable contents = clipboard.getContents(this);
			if (contents == null)
				return;
			String text;
			text = "";
			try {
				text = (String) contents.getTransferData(DataFlavor.stringFlavor);
			} catch (Exception exception) {
			}
			textArea.replaceRange(text, textArea.getSelectionStart(), textArea.getSelectionEnd());
		} else if (eventSource == formatItem) {
			@SuppressWarnings("unused")
			Format format = new Format(font, ysColor, dsColor);
		} else if (eventSource == exitItem) {
			System.exit(0);
		}
	}

	public void readFile(String fileName) {
		try {
			File file = new File(fileName);
			FileReader readIn = new FileReader(file);
			int size = (int) file.length();
			int charsRead = 0;
			char[] content = new char[size];
			while (readIn.ready())
				charsRead += readIn.read(content, charsRead, size - charsRead);
			readIn.close();
			textArea.setText(new String(content, 0, charsRead));
		} catch (IOException e) {
			System.out.println("Error opening File");
		}
	}

	public void writeFile(String fileName) {
		try {
			File file = new File(fileName);
			FileWriter writeOut = new FileWriter(file);
			writeOut.write(textArea.getText());
			writeOut.close();
		} catch (IOException e) {
			System.out.println("Error writing file");
		}
	}

	public static void setFontColor(Font f, Color ys, Color ds) {
		font = f;
		ysColor = ys;
		dsColor = ds;
		textArea.setFont(font);
		textArea.setBackground(dsColor);
		textArea.setForeground(ysColor);
	}

	public static void main(String[] args) {
		frame = new TextEditer();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameSize = frame.getSize();
		if (frameSize.height > screenSize.height) {
			frameSize.height = screenSize.height;
		}
		if (frameSize.width > screenSize.width) {
			frameSize.width = screenSize.width;
		}
		frame.setLocation((screenSize.width - frameSize.width) / 3, (screenSize.height - frameSize.height) / 3);
		frame.setVisible(true);
	}

}

@SuppressWarnings("serial")
class Format extends Frame implements ItemListener, AdjustmentListener {
	Panel ztPanel, zxPanel, dxPanel, ysPanel, dsPanel, slPanel, gyPanel; // 字体，字形，大小，颜色，底色，示例，关于
	Label ztLabel, zxLabel, dxLabel, ysLabel, ysRLabel, ysGLabel, ysBLabel, dsLabel, dsRLabel, dsGLabel, dsBLabel,
			slLabel, gyLabel, gysjLabel, gyzzLabel;
	TextField ztField, zxField, dxField, ysRField, ysGField, ysBField, dsRField, dsGField, dsBField;
	Choice ysChoice, dsChoice;
	List ztList, zxList, dxList;
	Scrollbar ysRScrollbar, ysGScrollbar, ysBScrollbar, dsRScrollbar, dsGScrollbar, dsBScrollbar;
	JTextArea slArea;
	Button yButton, nButton;
	static Font font;
	static Color ysColor, dsColor;

	public Format(Font font, Color ysColor, Color dsColor) {
		Format.font = font;
		Format.ysColor = ysColor;
		Format.dsColor = dsColor;
		ztPanel = new Panel(null);
		zxPanel = new Panel(null);
		dxPanel = new Panel(null);
		ysPanel = new Panel(null);
		dsPanel = new Panel(null);
		slPanel = new Panel(null);
		gyPanel = new Panel(null);
		ztLabel = new Label("字体");
		zxLabel = new Label("字形");
		dxLabel = new Label("大小");
		ysLabel = new Label("颜色");
		ysRLabel = new Label("R");
		ysGLabel = new Label("G");
		ysBLabel = new Label("B");
		dsLabel = new Label("底色");
		dsRLabel = new Label("R");
		dsGLabel = new Label("G");
		dsBLabel = new Label("B");
		slLabel = new Label("示例");
		gyLabel = new Label("关于");
		gysjLabel = new Label("2015/05/19");
		gyzzLabel = new Label("Made by 王悦");
		yButton = new Button("确认");
		nButton = new Button("取消");
		ztField = new TextField(font.getFontName());
		ztField.setEditable(false);
		ztList = new List();
		String fontname[] = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
		for (int i = 0; i < fontname.length; i++) {
			ztList.add(fontname[i]);
		}
		String fontStyle;
		switch (font.getStyle()) {
		case 0:
			fontStyle = new String("常规");
			break;
		case 1:
			fontStyle = new String("倾斜");
			break;
		case 2:
			fontStyle = new String("粗体");
			break;
		case 3:
			fontStyle = new String("粗体 倾斜");
			break;
		default:
			fontStyle = null;
			break;
		}
		zxField = new TextField(fontStyle);
		zxField.setEditable(false);
		zxList = new List();
		zxList.add("常规");
		zxList.add("粗体");
		zxList.add("倾斜");
		zxList.add("粗体 倾斜");
		dxField = new TextField(font.getSize() + "");
		dxList = new List();
		for (int i = 8; i <= 11; i++) {
			dxList.add(i + "");
		}
		for (int i = 12; i <= 28; i += 2) {
			dxList.add(i + "");
		}
		dxList.add("36");
		dxList.add("48");
		dxList.add("72");
		ysRField = new TextField(ysColor.getRed() + "");
		ysRField.setEditable(false);
		ysGField = new TextField(ysColor.getGreen() + "");
		ysGField.setEditable(false);
		ysBField = new TextField(ysColor.getBlue() + "");
		ysBField.setEditable(false);
		dsRField = new TextField(dsColor.getRed() + "");
		dsRField.setEditable(false);
		dsGField = new TextField(dsColor.getGreen() + "");
		dsGField.setEditable(false);
		dsBField = new TextField(dsColor.getBlue() + "");
		dsBField.setEditable(false);
		slArea = new JTextArea("AaBbCc\n记事本");
		ysChoice = new Choice();
		dsChoice = new Choice();
		String ChoString[] = new String[] { "black", "blue", "cyan", "darkGray", "gray", "green", "lightGray",
				"magenta", "orange", "pink", "red", "white", "yellow", "自定义" };
		System.setProperty("black", "0x000000");
		System.setProperty("blue", "0x0000ff");
		System.setProperty("cyan", "0x00ffff");
		System.setProperty("darkGray", "0x404040");
		System.setProperty("gray", "0x808080");
		System.setProperty("green", "0x00ff00");
		System.setProperty("lightGray", "0xc0c0c0");
		System.setProperty("magenta", "0xff00ff");
		System.setProperty("orange", "0xffc800");
		System.setProperty("pink", "0xffafaf");
		System.setProperty("red", "0xff0000");
		System.setProperty("white", "0xffffff");
		System.setProperty("yellow", "0xffff00");
		for (int i = 0; i < ChoString.length; i++) {
			ysChoice.add(ChoString[i]);
			dsChoice.add(ChoString[i]);
			if (ysColor.equals(Color.getColor(ChoString[i])))
				ysChoice.select(ChoString[i]);
			if (dsColor.equals(Color.getColor(ChoString[i])))
				dsChoice.select(ChoString[i]);
		}
		ysRScrollbar = new Scrollbar(Scrollbar.VERTICAL, ysColor.getRed(), 1, 0, 256);
		ysGScrollbar = new Scrollbar(Scrollbar.VERTICAL, ysColor.getGreen(), 1, 0, 256);
		ysBScrollbar = new Scrollbar(Scrollbar.VERTICAL, ysColor.getBlue(), 1, 0, 256);
		dsRScrollbar = new Scrollbar(Scrollbar.VERTICAL, dsColor.getRed(), 1, 0, 256);
		dsGScrollbar = new Scrollbar(Scrollbar.VERTICAL, dsColor.getGreen(), 1, 0, 256);
		dsBScrollbar = new Scrollbar(Scrollbar.VERTICAL, dsColor.getBlue(), 1, 0, 256);

		setLayout(null);
		ztPanel.setBackground(Color.red);
		ztPanel.setBounds(10, 32, 150, 200);
		ztLabel.setBounds(5, 5, 30, 15);
		ztPanel.add(ztLabel);
		ztField.setBounds(5, 20, 140, 20);
		ztPanel.add(ztField);
		ztList.setBounds(5, 45, 140, 150);
		ztPanel.add(ztList);
		add(ztPanel);

		zxPanel.setBackground(Color.pink);
		zxPanel.setBounds(165, 32, 100, 200);
		zxLabel.setBounds(5, 5, 30, 15);
		zxPanel.add(zxLabel);
		zxField.setBounds(5, 20, 90, 20);
		zxPanel.add(zxField);
		zxList.setBounds(5, 45, 90, 150);
		zxPanel.add(zxList);
		add(zxPanel);

		dxPanel.setBackground(Color.yellow);
		dxPanel.setBounds(270, 32, 100, 200);
		dxLabel.setBounds(5, 5, 30, 15);
		dxPanel.add(dxLabel);
		dxField.setBounds(5, 20, 90, 20);
		dxPanel.add(dxField);
		dxList.setBounds(5, 45, 90, 150);
		dxPanel.add(dxList);
		add(dxPanel);

		ysPanel.setBackground(Color.blue);
		ysPanel.setBounds(10, 237, 100, 225);
		ysLabel.setBounds(5, 5, 30, 15);
		ysPanel.add(ysLabel);
		ysChoice.setBounds(5, 25, 90, 15);
		ysPanel.add(ysChoice);
		ysRLabel.setBounds(13, 50, 15, 15);
		ysPanel.add(ysRLabel);
		ysRScrollbar.setBounds(7, 65, 26, 130);
		ysPanel.add(ysRScrollbar);
		ysRField.setBounds(5, 200, 30, 20);
		ysPanel.add(ysRField);
		ysGLabel.setBounds(43, 50, 15, 15);
		ysPanel.add(ysGLabel);
		ysGScrollbar.setBounds(37, 65, 26, 130);
		ysPanel.add(ysGScrollbar);
		ysGField.setBounds(35, 200, 30, 20);
		ysPanel.add(ysGField);
		ysBLabel.setBounds(73, 50, 15, 15);
		ysPanel.add(ysBLabel);
		ysBScrollbar.setBounds(67, 65, 26, 130);
		ysPanel.add(ysBScrollbar);
		ysBField.setBounds(65, 200, 30, 20);
		ysPanel.add(ysBField);
		add(ysPanel);

		dsPanel.setBackground(Color.cyan);
		dsPanel.setBounds(115, 237, 100, 225);
		dsLabel.setBounds(5, 5, 30, 15);
		dsPanel.add(dsLabel);
		dsChoice.setBounds(5, 25, 90, 15);
		dsPanel.add(dsChoice);
		dsRLabel.setBounds(13, 50, 15, 15);
		dsPanel.add(dsRLabel);
		dsRScrollbar.setBounds(7, 65, 26, 130);
		dsPanel.add(dsRScrollbar);
		dsRField.setBounds(5, 200, 30, 20);
		dsPanel.add(dsRField);
		dsGLabel.setBounds(43, 50, 15, 15);
		dsPanel.add(dsGLabel);
		dsGScrollbar.setBounds(37, 65, 26, 130);
		dsPanel.add(dsGScrollbar);
		dsGField.setBounds(35, 200, 30, 20);
		dsPanel.add(dsGField);
		dsBLabel.setBounds(73, 50, 15, 15);
		dsPanel.add(dsBLabel);
		dsBScrollbar.setBounds(67, 65, 26, 130);
		dsPanel.add(dsBScrollbar);
		dsBField.setBounds(65, 200, 30, 20);
		dsPanel.add(dsBField);
		add(dsPanel);

		slPanel.setBackground(Color.green);
		slPanel.setBounds(220, 237, 150, 155);
		slLabel.setBounds(5, 5, 30, 15);
		slPanel.add(slLabel);
		slArea.setBounds(5, 25, 140, 85);
		slArea.setFont(font);
		slArea.setBackground(dsColor);
		slArea.setForeground(ysColor);
		slPanel.add(slArea);
		nButton.setBounds(15, 120, 50, 25);
		slPanel.add(nButton);
		yButton.setBounds(85, 120, 50, 25);
		slPanel.add(yButton);
		add(slPanel);

		gyPanel.setBackground(Color.ORANGE);
		gyPanel.setBounds(220, 397, 150, 65);
		gyLabel.setBounds(10, 6, 30, 20);
		gyPanel.add(gyLabel);
		gyzzLabel.setBounds(55, 31, 90, 20);
		gyPanel.add(gyzzLabel);
		gysjLabel.setBounds(65, 46, 90, 20);
		gyPanel.add(gysjLabel);
		add(gyPanel);

		ztList.addItemListener(this);
		zxList.addItemListener(this);
		dxList.addItemListener(this);
		ysChoice.addItemListener(this);
		dsChoice.addItemListener(this);
		ysRScrollbar.addAdjustmentListener(this);
		ysGScrollbar.addAdjustmentListener(this);
		ysBScrollbar.addAdjustmentListener(this);
		dsRScrollbar.addAdjustmentListener(this);
		dsGScrollbar.addAdjustmentListener(this);
		dsBScrollbar.addAdjustmentListener(this);
		yButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TextEditer.setFontColor(Format.font, Format.ysColor, Format.dsColor);
				setVisible(false);
				dispose();
			}
		});
		nButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
			}
		});
		setBackground(Color.lightGray);
		setTitle("字体格式");
		setSize(371, 462);
		setVisible(true);
		setLocation(TextEditer.frame.getLocation());
		setResizable(false);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent evt) {
				setVisible(false);
				dispose();
			}
		});
	}

	public void itemStateChanged(ItemEvent eve) {
		if (eve.getSource() == ztList) {
			ztField.setText(ztList.getSelectedItem());
		} else if (eve.getSource() == zxList) {
			zxField.setText(zxList.getSelectedItem());
		} else if (eve.getSource() == dxList) {
			dxField.setText(dxList.getSelectedItem());
		} else if (eve.getSource() == ysChoice) {
			if (ysChoice.getSelectedItem() != "自定义") {
				ysColor = Color.getColor(ysChoice.getSelectedItem());
				ysRField.setText(ysColor.getRed() + "");
				ysRScrollbar.setValue(ysColor.getRed());
				ysGField.setText(ysColor.getGreen() + "");
				ysGScrollbar.setValue(ysColor.getGreen());
				ysBField.setText(ysColor.getBlue() + "");
				ysBScrollbar.setValue(ysColor.getBlue());
			} else {
				ysColor = new Color(ysRScrollbar.getValue(), ysGScrollbar.getValue(), ysBScrollbar.getValue());
			}
		} else if (eve.getSource() == dsChoice) {
			if (dsChoice.getSelectedItem() != "自定义") {
				dsColor = Color.getColor(dsChoice.getSelectedItem());
				dsRField.setText(dsColor.getRed() + "");
				dsRScrollbar.setValue(dsColor.getRed());
				dsGField.setText(dsColor.getGreen() + "");
				dsGScrollbar.setValue(dsColor.getGreen());
				dsBField.setText(dsColor.getBlue() + "");
				dsBScrollbar.setValue(dsColor.getBlue());
			} else {
				dsColor = new Color(dsRScrollbar.getValue(), dsGScrollbar.getValue(), dsBScrollbar.getValue());
			}
		}
		font = new Font(ztField.getText(), zxList.getSelectedIndex(), Integer.parseInt(dxField.getText()));
		slArea.setFont(font);
		slArea.setBackground(dsColor);
		slArea.setForeground(ysColor);
	}

	public void adjustmentValueChanged(AdjustmentEvent eve) {
		if (eve.getSource() == ysRScrollbar) {
			ysChoice.select("自定义");
			ysRField.setText(Integer.toString(((Scrollbar) eve.getSource()).getValue()));
			ysColor = new Color(ysRScrollbar.getValue(), ysGScrollbar.getValue(), ysBScrollbar.getValue());
		} else if (eve.getSource() == ysGScrollbar) {
			ysChoice.select("自定义");
			ysGField.setText(Integer.toString(((Scrollbar) eve.getSource()).getValue()));
			ysColor = new Color(ysRScrollbar.getValue(), ysGScrollbar.getValue(), ysBScrollbar.getValue());
		} else if (eve.getSource() == ysBScrollbar) {
			ysChoice.select("自定义");
			ysBField.setText(Integer.toString(((Scrollbar) eve.getSource()).getValue()));
			ysColor = new Color(ysRScrollbar.getValue(), ysGScrollbar.getValue(), ysBScrollbar.getValue());
		} else if (eve.getSource() == dsRScrollbar) {
			dsChoice.select("自定义");
			dsRField.setText(Integer.toString(((Scrollbar) eve.getSource()).getValue()));
			dsColor = new Color(dsRScrollbar.getValue(), dsGScrollbar.getValue(), dsBScrollbar.getValue());
		} else if (eve.getSource() == dsGScrollbar) {
			dsChoice.select("自定义");
			dsGField.setText(Integer.toString(((Scrollbar) eve.getSource()).getValue()));
			dsColor = new Color(dsRScrollbar.getValue(), dsGScrollbar.getValue(), dsBScrollbar.getValue());
		} else if (eve.getSource() == dsBScrollbar) {
			dsChoice.select("自定义");
			dsBField.setText(Integer.toString(((Scrollbar) eve.getSource()).getValue()));
			dsColor = new Color(dsRScrollbar.getValue(), dsGScrollbar.getValue(), dsBScrollbar.getValue());
		}
		slArea.setBackground(dsColor);
		slArea.setForeground(ysColor);
	}

}
