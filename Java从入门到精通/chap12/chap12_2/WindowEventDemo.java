package chap12_2;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

@SuppressWarnings("serial")
public class WindowEventDemo extends Frame{
	public WindowEventDemo(){
		super();
		init();
	}
	public static void main(String[] args) {
		new WindowEventDemo();
	}
	public void init(){
		addWindowListener(new WindowListener() {
			public void windowOpened(WindowEvent e) {
				
			}
			public void windowIconified(WindowEvent e) {
				
			}
			public void windowDeiconified(WindowEvent e) {
				
			}
			public void windowDeactivated(WindowEvent e) {
				
			}
			public void windowClosing(WindowEvent e) {
				str="windowClosing";
				System.out.println(str);
				setVisible(false);
				dispose();
				System.exit(0);
			}
			public void windowClosed(WindowEvent e) {
				str="windowClosing";
				System.out.println(str);
				repaint();
			}
			public void windowActivated(WindowEvent e) {
				str="windowActivated";
				System.out.println(str);
				repaint();
			}
		});
		setSize(200,200);
		setVisible(true);
	}
	public void paint(Graphics g){
		g.drawString(str, 30, 100);
	}
	String str=null;
}
