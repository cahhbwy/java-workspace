package chap13_6;

import java.awt.FileDialog;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;

@SuppressWarnings("serial")
public class NoteBook extends JFrame implements ActionListener{
	JMenu fileMenu=new JMenu("文件");
	JMenu editMenu=new JMenu("编辑");
	JMenuItem newitem=new JMenuItem("新建");
	JMenuItem openitem=new JMenuItem("打开");
	JMenuItem saveitem=new JMenuItem("保存");
	JMenuItem saveAsitem=new JMenuItem("另存");
	JMenuItem exititem=new JMenuItem("退出");
	JMenuItem selectitem=new JMenuItem("全选");
	JMenuItem copyitem=new JMenuItem("复制");
	JMenuItem cutitem=new JMenuItem("剪切");
	JMenuItem pastitem=new JMenuItem("粘贴");
	@SuppressWarnings("unused")
	private FileDialog openFileDialog=new FileDialog(this, "Open File", FileDialog.LOAD);
	@SuppressWarnings("unused")
	private FileDialog saveAsFileDialog=new FileDialog(this, "Save File As", FileDialog.SAVE);
	String fileName="NoName.txt";
	final JTextArea textArea=new JTextArea();
	JMenuBar menuBar=new JMenuBar();
	String title="ERROR MESSAGE";
	int type=JOptionPane.ERROR_MESSAGE;
	
	public NoteBook(){
		setSize(600, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel=new JPanel();
		panel.setLayout(new GridLayout(1, 1));
		panel.add(new JScrollPane(textArea));
		getContentPane().add(panel);
		setJMenuBar(menuBar);
		menuBar.add(fileMenu);
		menuBar.add(editMenu);
		fileMenu.add(newitem);
		fileMenu.add(openitem);
		fileMenu.addSeparator();
		fileMenu.add(saveitem);
		fileMenu.add(saveAsitem);
		fileMenu.addSeparator();
		fileMenu.add(exititem);
		editMenu.add(selectitem);
		editMenu.addSeparator();
		editMenu.add(copyitem);
		editMenu.add(cutitem);
		editMenu.add(pastitem);
		newitem.addActionListener(this);
		newitem.setMnemonic('N');
		newitem.setAccelerator(KeyStroke.getKeyStroke('N', java.awt.Event.CTRL_MASK,true));
		openitem.addActionListener(this);
		openitem.setMnemonic('O');
		openitem.setAccelerator(KeyStroke.getKeyStroke('O', java.awt.Event.CTRL_MASK, true));
		saveitem.addActionListener(this);
		saveitem.setMnemonic('S');
		saveitem.setAccelerator(KeyStroke.getKeyStroke('S', java.awt.Event.CTRL_MASK, true));
		saveAsitem.addActionListener(this);
		saveAsitem.setMnemonic('T');
		saveAsitem.setAccelerator(KeyStroke.getKeyStroke('T', java.awt.Event.CTRL_MASK, true));
		exititem.addActionListener(this);
		exititem.setMnemonic('Q');
		exititem.setAccelerator(KeyStroke.getKeyStroke('Q', java.awt.Event.CTRL_MASK, true));
		selectitem.addActionListener(this);
		selectitem.setMnemonic('A');
		selectitem.setAccelerator(KeyStroke.getKeyStroke('A', java.awt.Event.CTRL_MASK, true));
		copyitem.addActionListener(this);
		copyitem.setMnemonic('C');
		copyitem.setAccelerator(KeyStroke.getKeyStroke('C', java.awt.Event.CTRL_MASK, true));
		cutitem.addActionListener(this);
		cutitem.setMnemonic('X');
		cutitem.setAccelerator(KeyStroke.getKeyStroke('X', java.awt.Event.CTRL_MASK, true));
		pastitem.addActionListener(this);
		pastitem.setMnemonic('P');
		pastitem.setAccelerator(KeyStroke.getKeyStroke('P', java.awt.Event.CTRL_MASK, true));
		setVisible(true);
	}
	public void actionPerformed(ActionEvent e){
		Object eventSource=e.getSource();
		if(eventSource==newitem){
			textArea.setText("");
		}else if (eventSource==openitem) {
			readFile();
		}else if (eventSource==saveitem) {
			fileName="NoName.txt";
			writeFile(fileName);
		}else if (eventSource==saveAsitem) {
			fileName=null;
			writeFile(fileName);
		}else if (eventSource==selectitem) {
			textArea.selectAll();
		}else if (eventSource==copyitem) {
			textArea.copy();
		}else if (eventSource==cutitem) {
			textArea.cut();
		}else if (eventSource==pastitem) {
			textArea.paste();
		}else if (eventSource==exititem) {
			System.exit(0);
		}
	}
	public void readFile(){
		JFileChooser openfile=new JFileChooser();
		openfile.setDialogTitle("打开文件");
		openfile.setApproveButtonText("打开");
		openfile.showOpenDialog(this);
		File file=openfile.getSelectedFile();
		if(file!=null){
			FileInputStream inputfile=null;
			String message="文件不能找到";
			try{
				inputfile=new FileInputStream(file);
			}catch(FileNotFoundException fe){
				JOptionPane.showMessageDialog(this, message, title, type);
			}
			int readbytes;
			String message1="读文件发生错误";
			try{
				while ((readbytes=inputfile.read())!=-1) {
					textArea.append(String.valueOf((char)readbytes));
				}
			}catch(IOException ioe){
				JOptionPane.showMessageDialog(this, message1, title, type);
			}
			String closemessage="关闭文件发生错误";
			try{
				inputfile.close();
			}catch(IOException ioe){
				JOptionPane.showMessageDialog(this, closemessage, title, type);
			}
		}
	}
	public void writeFile(String fileName){
		File filesa;
		String messagef="文件未找到";
		FileOutputStream outputfile=null;
		if(fileName==null){
			JFileChooser savefile=new JFileChooser();
			savefile.setApproveButtonText("保存");
			savefile.showSaveDialog(this);
			filesa=savefile.getSelectedFile();
			if(filesa==null)	return;
		}else {
			filesa=new File(fileName);
		}
		try{
			outputfile=new FileOutputStream(filesa);
		}catch(FileNotFoundException fe){
			JOptionPane.showMessageDialog(this, messagef, title, type);
		}
		String filecontent=textArea.getText();
		String wrmessage="写文件错误";
		try{
			outputfile.write(filecontent.getBytes());
		}catch(IOException ioe){
			JOptionPane.showMessageDialog(this, wrmessage, title, type);
		}
		String cmmessage="关闭流发生错误";
		try{
			outputfile.close();
		}catch(IOException ioe){
			JOptionPane.showMessageDialog(this, cmmessage, title, type);
		}
	}
	@SuppressWarnings("unused")
	public static void main(String[] args){
		NoteBook notebook=new NoteBook();
	}
	
	
}
