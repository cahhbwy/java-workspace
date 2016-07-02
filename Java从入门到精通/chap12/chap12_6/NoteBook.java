package chap12_6;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FileDialog;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.TextArea;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

@SuppressWarnings("serial")
public class NoteBook extends Frame implements ActionListener{
	MenuBar menuBar=new MenuBar();
	TextArea textArea=new TextArea();
	//文件菜单
	Menu fileMenu=new Menu("文件");
	MenuItem newItem=new MenuItem("新建");
	MenuItem openItem=new MenuItem("打开");
	MenuItem saveItem=new MenuItem("保存");
	MenuItem saveAsItem=new MenuItem("另存");
	MenuItem exitItem=new MenuItem("退出");
	//编辑菜单
	Menu editMenu=new Menu("编辑");
	MenuItem selectItem=new MenuItem("全选");
	MenuItem copyItem=new MenuItem("复制");
	MenuItem cutItem=new MenuItem("剪切");
	MenuItem pasteItem=new MenuItem("粘贴");
	String fileName="NoName.txt";
	Toolkit toolkit=Toolkit.getDefaultToolkit();
	Clipboard clipboard=toolkit.getSystemClipboard();
	//创建并初始化打开文件对话框&保存文件对话框
	private FileDialog openFileDialog=new FileDialog(this,"Open File",FileDialog.LOAD);
	private FileDialog saveAsFileDialog=new FileDialog(this, "Save File As", FileDialog.SAVE);
	//实现NoteBook构造方法
	public NoteBook(){
		setTitle("NoteBook");
		setFont(new Font("Times New Roman",Font.PLAIN,12));
		setBackground(Color.white);
		setSize(600,400);
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
		menuBar.add(fileMenu);
		menuBar.add(editMenu);
		setMenuBar(menuBar);
		add(textArea);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){
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
	}
	public void actionPerformed(ActionEvent e){
		Object eventSource=e.getSource();
		if(eventSource==newItem){
			textArea.setText("");
		}else if (eventSource==openItem) {
			openFileDialog.setVisible(true);
			fileName=openFileDialog.getDirectory()+openFileDialog.getFile();
			if(fileName!=null)
				readFile(fileName);
		}else if(eventSource==saveItem){
			if(fileName!=null)
				writeFile(fileName);
		}else if(eventSource==saveAsItem){
			saveAsFileDialog.setVisible(true);
			fileName =saveAsFileDialog.getDirectory()+saveAsFileDialog.getFile();
			if(fileName!=null)
				writeFile(fileName);
		}else if(eventSource==selectItem){
			textArea.selectAll();
		}else if(eventSource==copyItem){
			String text=textArea.getSelectedText();
			StringSelection selection=new StringSelection(text);
			clipboard.setContents(selection, null);
		}else if(eventSource==cutItem){
			String text=textArea.getSelectedText();
			StringSelection selection=new StringSelection(text);
			clipboard.setContents(selection, null);
			textArea.replaceRange("", textArea.getSelectionStart(), textArea.getSelectionEnd());
		}else if(eventSource==pasteItem){
			Transferable contents=clipboard.getContents(this);
			if(contents==null)
				return;
			String text;
			text="";
			try{
				text=(String)contents.getTransferData(DataFlavor.stringFlavor);
			}catch(Exception exception){
			}
			textArea.replaceRange(text, textArea.getSelectionStart(),textArea.getSelectionEnd());
		}else if(eventSource==exitItem){
			System.exit(0);
		}
	}
	public void readFile(String fileName){
		try{
			File file=new File(fileName);
			FileReader readIn=new FileReader(file);
			int size=(int)file.length();
			int charsRead=0;
			char[] content =new char[size];
			while(readIn.ready())
				charsRead+=readIn.read(content,charsRead,size-charsRead);
			readIn.close();
			textArea.setText(new String(content,0,charsRead));
		}catch(IOException e){
			System.out.println("Error opening File");
		}
	}
	public void writeFile(String fileName){
		try{
			File file=new File(fileName);
			FileWriter writeOut=new FileWriter(file);
			writeOut.write(textArea.getText());
			writeOut.close();
		}catch(IOException e){
			System.out.println("Error writing file");
		}
	}
	public static void main(String[] args) {
		Frame frame=new NoteBook();
		Dimension screenSize=Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameSize=frame.getSize();
		if(frameSize.height>screenSize.height){
			frameSize.height=screenSize.height;
		}
		if(frameSize.width>screenSize.width){
			frameSize.width=screenSize.width;
		}
		frame.setLocation((screenSize.width-frameSize.width)/2,(screenSize.height-frameSize.height)/2);
		frame.setVisible(true);
	}

}
