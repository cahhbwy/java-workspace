package chap11_5;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

@SuppressWarnings("serial")
public class FontDemo extends Frame{
	public FontDemo(String str){
		super(str);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent evt){
				setVisible(false);
				dispose();
				System.exit(0);
			}
		});
	}
	public static void main(String[] args) {
		FontDemo f=new FontDemo("字体大小和颜色");
		f.setBackground(Color.black);
		f.setSize(400,300);
		f.setVisible(true);
	}
	public void paint(Graphics g){
		Font font=new Font("楷体",Font.BOLD,18);
		g.setColor(Color.red);
		g.setFont(font);
		g.drawString("Font:"+font.getName()+font.getSize(), 30, 50);
		g.setFont(new Font("宋体",Font.BOLD,18));
		g.drawString("2008 北京奥运会", 20, 120);
		g.setColor(new Color(0,0,0));
	}
}
