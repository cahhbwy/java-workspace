package ec;

import java.awt.*;
import java.awt.event.*;
import java.io.*;

import javax.swing.*;

public class MainGUI extends Frame implements ActionListener, ItemListener {
	private static final long serialVersionUID = 8217197759420689514L;
	Button ecpbtn, dcpbtn, cmpbtn, dcmbtn, openbtn, savebtn, morebtn, basebtn, recbtn, uecbtn;
	Label opraLabel, openLabel, saveLabel, levelLabel;
	TextField foTF, fsTF;
	Checkbox lowcb, midcb, highcb;
	CheckboxGroup levelcbg;
	String nameopen, namesave;
	Panel p, p1, p2;
	CardLayout cl;
	short level;
	private FileDialog openFileDialog = new FileDialog(this, "Open File", FileDialog.LOAD);
	private FileDialog saveAsFileDialog = new FileDialog(this, "Save File As", FileDialog.SAVE);

	Compress com;
	Encryption ec;

	public MainGUI(String name) {
		super(name);
		this.level=1;
	}

	private void init() {
		ecpbtn = new Button("加密");
		dcpbtn = new Button("解密");
		cmpbtn = new Button("压缩");
		dcmbtn = new Button("解压");
		openbtn = new Button("打开");
		savebtn = new Button("保存");
		morebtn = new Button("更多");
		basebtn = new Button("基本");
		recbtn = new Button("加密压缩");
		uecbtn = new Button("解密解压");
		opraLabel = new Label("操作");
		openLabel = new Label("打开自：");
		saveLabel = new Label("保存为：");
		levelLabel = new Label("加密强度");
		foTF = new TextField(20);
		foTF.setEditable(false);
		fsTF = new TextField(20);
		fsTF.setEditable(false);
		levelcbg = new CheckboxGroup();
		lowcb = new Checkbox("low", levelcbg, true);
		lowcb.addItemListener(this);
		midcb = new Checkbox("middle", levelcbg, false);
		midcb.addItemListener(this);
		highcb = new Checkbox("high", levelcbg, false);
		highcb.addItemListener(this);
		cl = new CardLayout();
		p = new Panel(cl);
		p1 = new Panel(null);
		p2 = new Panel(null);
		setLayout(null);
		openLabel.setBounds(20, 40, 70, 20);
		add(openLabel);
		foTF.setBounds(90, 40, 200, 20);
		add(foTF);
		openbtn.setBounds(310, 38, 50, 24);
		add(openbtn);
		saveLabel.setBounds(20, 70, 70, 20);
		add(saveLabel);
		fsTF.setBounds(90, 70, 200, 20);
		add(fsTF);
		savebtn.setBounds(310, 68, 50, 24);
		add(savebtn);
		p.setBounds(10, 100, 370, 200);
		opraLabel.setBounds(20, 0, 60, 20);
		p1.add(opraLabel);
		ecpbtn.setBounds(40, 20, 120, 50);
		p1.add(ecpbtn);
		dcpbtn.setBounds(200, 20, 120, 50);
		p1.add(dcpbtn);
		cmpbtn.setBounds(40, 90, 120, 50);
		p1.add(cmpbtn);
		dcmbtn.setBounds(200, 90, 120, 50);
		p1.add(dcmbtn);
		morebtn.setBounds(260, 150, 70, 30);
		p1.add(morebtn);
		levelLabel.setBounds(20, 0, 120, 20);
		p2.add(levelLabel);
		lowcb.setBounds(60, 30, 90, 30);
		p2.add(lowcb);
		midcb.setBounds(60, 70, 90, 30);
		p2.add(midcb);
		highcb.setBounds(60, 110, 90, 30);
		p2.add(highcb);
		recbtn.setBounds(170, 20, 100, 60);
		p2.add(recbtn);
		uecbtn.setBounds(170, 80, 100, 60);
		p2.add(uecbtn);
		basebtn.setBounds(260, 150, 70, 30);

		ecpbtn.addActionListener(this);
		dcpbtn.addActionListener(this);
		cmpbtn.addActionListener(this);
		dcmbtn.addActionListener(this);
		openbtn.addActionListener(this);
		savebtn.addActionListener(this);
		morebtn.addActionListener(this);
		basebtn.addActionListener(this);
		recbtn.addActionListener(this);
		uecbtn.addActionListener(this);

		p2.add(basebtn);
		p.add("basic", p1);
		p.add("more", p2);
		add(p);
		setSize(380, 300);
		setResizable(false);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent evt) {
				setVisible(false);
				dispose();
				System.exit(0);
			}
		});
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameSize = getSize();
		if (frameSize.height > screenSize.height) {
			frameSize.height = screenSize.height;
		}
		if (frameSize.width > screenSize.width) {
			frameSize.width = screenSize.width;
		}
		setLocation((screenSize.width - frameSize.width) / 3, (screenSize.height - frameSize.height) / 3);
		setVisible(true);
	}

	public static void main(String[] args) {
		MainGUI mainGUI = new MainGUI("加密&压缩");
		mainGUI.init();
		//made by Yue Wang
		//2015.05.30
	}

	public void actionPerformed(ActionEvent evt) {
		if (evt.getSource() == openbtn) {
			openFileDialog.setVisible(true);
			nameopen = openFileDialog.getDirectory() + openFileDialog.getFile();
			if (!nameopen.equals("nullnull") || nameopen == null) {
				if (nameopen.endsWith(".ecp") || nameopen.endsWith(".cpr") || nameopen.endsWith("ecr")) {
					namesave = openFileDialog.getDirectory() + "u"
							+ openFileDialog.getFile().substring(0, openFileDialog.getFile().length() - 4);
					fsTF.setText("u"
							+ openFileDialog.getFile().substring(0, openFileDialog.getFile().length() - 4));
				} else {
					namesave = openFileDialog.getDirectory() + openFileDialog.getFile().concat(".ecr");
					fsTF.setText(openFileDialog.getFile().concat(".ecr"));
				}
				foTF.setText(openFileDialog.getFile());
			}
		} else if (evt.getSource() == savebtn) {
			saveAsFileDialog.setVisible(true);
			namesave = saveAsFileDialog.getDirectory() + saveAsFileDialog.getFile();
			if (!namesave.equals("nullnull") || namesave == null) {
				if (openFileDialog.getDirectory().equals(saveAsFileDialog.getDirectory())) {
					fsTF.setText(saveAsFileDialog.getFile());
				} else {
					foTF.setText(nameopen);
					fsTF.setText(namesave);
				}
			}
		} else if (evt.getSource() == morebtn) {
			cl.last(p);
		} else if (evt.getSource() == basebtn) {
			cl.first(p);
		} else if (evt.getSource() == ecpbtn) {
			if (nameopen == null || nameopen.endsWith("null") || namesave == null
					|| namesave.endsWith("null")) {
				JOptionPane.showMessageDialog(null, "输入文件名称");
				return;
			}
			String password = JOptionPane.showInputDialog("输入密码");
			if (password == null)
				return;
			ec = new Encryption();
			try {
				if (ec.startDependent(nameopen, namesave, true, password)) {
					JOptionPane.showMessageDialog(null, "加密成功");
				} else {
					JOptionPane.showMessageDialog(null, "加密失败");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else if (evt.getSource() == dcpbtn) {
			if (nameopen == null || nameopen.endsWith("null") || namesave == null
					|| namesave.endsWith("null")) {
				JOptionPane.showMessageDialog(null, "输入文件名称");
				return;
			}
			String password = JOptionPane.showInputDialog("输入密码");
			if (password == null)
				return;
			ec = new Encryption();
			try {
				if (ec.startDependent(nameopen, namesave, false, password)) {
					JOptionPane.showMessageDialog(null, "解密成功");
				} else {
					JOptionPane.showMessageDialog(null, "解密失败");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else if (evt.getSource() == cmpbtn) {
			if (nameopen == null || nameopen.endsWith("null") || namesave == null
					|| namesave.endsWith("null")) {
				JOptionPane.showMessageDialog(null, "输入文件名称");
				return;
			}
			com = new Compress();
			try {
				if (com.startDependent(nameopen, namesave, true)) {
					JOptionPane.showMessageDialog(null, "压缩成功");
				} else {
					JOptionPane.showMessageDialog(null, "压缩失败");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else if (evt.getSource() == dcmbtn) {
			if (nameopen == null || nameopen.endsWith("null") || namesave == null
					|| namesave.endsWith("null")) {
				JOptionPane.showMessageDialog(null, "输入文件名称");
				return;
			}
			com = new Compress();
			try {
				if (com.startDependent(nameopen, namesave, false)) {
					JOptionPane.showMessageDialog(null, "解压成功");
				} else {
					JOptionPane.showMessageDialog(null, "解压失败");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else if (evt.getSource() == recbtn) {
			System.out.println(level);
			if (nameopen == null || nameopen.endsWith("null") || namesave == null
					|| namesave.endsWith("null")) {
				JOptionPane.showMessageDialog(null, "输入文件名称");
				return;
			}
			String password = JOptionPane.showInputDialog("输入密码");
			if (password == null)
				return;
			com = new Compress();
			ec = new Encryption();
			try {
				switch (level) {
					case 1:
						if (ec.startDependent(nameopen, "ec1", true, password)
								&& com.startDependent("ec1", "ec2", true)
								&& ec.startDependent("ec2", namesave, true, password)) {
							JOptionPane.showMessageDialog(null, "加密压缩成功");
						} else {
							JOptionPane.showMessageDialog(null, "加密压缩失败");
						}
						new File("ec1").delete();
						new File("ec2").delete();
						break;
					case 2:
						if (ec.startDependent(nameopen, "ec1", true, password)
								&& com.startDependent("ec1", "ec2", true)
								&& ec.startDependent("ec2", "ec3", true, password)
								&& com.startDependent("ec3", "ec4", true)
								&& ec.startDependent("ec4", namesave, true, password)) {
							JOptionPane.showMessageDialog(null, "加密压缩成功");
						} else {
							JOptionPane.showMessageDialog(null, "加密压缩失败");
						}
						new File("ec1").delete();
						new File("ec2").delete();
						new File("ec3").delete();
						new File("ec4").delete();
						break;
					case 3:
						if (ec.startDependent(nameopen, "ec1", true, password)
								&& com.startDependent("ec1", "ec2", true)
								&& ec.startDependent("ec2", "ec3", true, password)
								&& com.startDependent("ec3", "ec4", true)
								&& ec.startDependent("ec4", "ec5", true, password)
								&& com.startDependent("ec5", "ec6", true)
								&& ec.startDependent("ec6", namesave, true, password)) {
							JOptionPane.showMessageDialog(null, "加密压缩成功");
						} else {
							JOptionPane.showMessageDialog(null, "加密压缩失败");
						}
						new File("ec1").deleteOnExit();
						new File("ec2").deleteOnExit();
						new File("ec3").deleteOnExit();
						new File("ec4").deleteOnExit();
						new File("ec5").deleteOnExit();
						new File("ec6").deleteOnExit();
						break;
					default:
						break;
				}
			} catch (HeadlessException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else if (evt.getSource() == uecbtn) {
			System.out.println(level);
			if (nameopen == null || nameopen.endsWith("null") || namesave == null
					|| namesave.endsWith("null")) {
				JOptionPane.showMessageDialog(null, "输入文件名称");
				return;
			}
			String password = JOptionPane.showInputDialog("输入密码");
			if (password == null)
				return;
			com = new Compress();
			ec = new Encryption();
			try {
				switch (level) {
					case 1:
						if (ec.startDependent(nameopen, "ec1", false, password)
								&& com.startDependent("ec1", "ec2", false)
								&& ec.startDependent("ec2", namesave, false, password)) {
							JOptionPane.showMessageDialog(null, "解密解压成功");
						} else {
							JOptionPane.showMessageDialog(null, "解密解压失败");
						}
						new File("ec1").delete();
						new File("ec2").delete();
						break;
					case 2:
						if (ec.startDependent(nameopen, "ec1", false, password)
								&& com.startDependent("ec1", "ec2", false)
								&& ec.startDependent("ec2", "ec3", false, password)
								&& com.startDependent("ec3", "ec4", false)
								&& ec.startDependent("ec4", namesave, false, password)) {
							JOptionPane.showMessageDialog(null, "解密解压成功");
						} else {
							JOptionPane.showMessageDialog(null, "解密解压失败");
						}
						new File("ec1").delete();
						new File("ec2").delete();
						new File("ec3").delete();
						new File("ec4").delete();
						break;
					case 3:
						if (ec.startDependent(nameopen, "ec1", false, password)
								&& com.startDependent("ec1", "ec2", false)
								&& ec.startDependent("ec2", "ec3", false, password)
								&& com.startDependent("ec3", "ec4", false)
								&& ec.startDependent("ec4", "ec5", false, password)
								&& com.startDependent("ec5", "ec6", false)
								&& ec.startDependent("ec6", namesave, false, password)) {
							JOptionPane.showMessageDialog(null, "解密解压成功");
						} else {
							JOptionPane.showMessageDialog(null, "解密解压失败");
						}
						new File("ec1").deleteOnExit();
						new File("ec2").deleteOnExit();
						new File("ec3").deleteOnExit();
						new File("ec4").deleteOnExit();
						new File("ec5").deleteOnExit();
						new File("ec6").deleteOnExit();
						break;
					default:
						break;
				}
			} catch (HeadlessException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void itemStateChanged(ItemEvent eve) {
		if (eve.getSource() == lowcb) {
			level = 1;
		}
		if (eve.getSource() == midcb) {
			level = 2;
		}
		if (eve.getSource() == highcb) {
			level = 3;
		}
	}
}
