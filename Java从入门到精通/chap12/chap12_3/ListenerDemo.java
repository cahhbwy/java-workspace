package chap12_3;

import java.awt.Frame;
import java.awt.TextField;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class ListenerDemo implements MouseMotionListener,MouseListener,WindowListener{
	private Frame f;
	private TextField tf1,tf2;
	public static void main(String[] args) {
		new ListenerDemo();
	}
	public ListenerDemo(){
		f=new Frame("请单击或者拖动鼠标");
		tf1=new TextField(20);
		tf2=new TextField(20);
		f.add("South",tf1);
		f.add("North",tf2);
		f.addMouseListener(this);
		f.addMouseMotionListener(this);
		f.addWindowListener(this);
		f.setSize(400,300);
		f.setVisible(true);
	}
	@Override
	public void windowActivated(WindowEvent e) {
	}
	@Override
	public void windowClosed(WindowEvent e) {
	}
	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}
	@Override
	public void windowDeactivated(WindowEvent e) {
	}
	@Override
	public void windowDeiconified(WindowEvent e) {
	}
	@Override
	public void windowIconified(WindowEvent e) {
	}
	@Override
	public void windowOpened(WindowEvent e) {
	}
	@Override
	public void mouseClicked(MouseEvent e) {
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		tf1.setText("鼠标进入");
	}
	@Override
	public void mouseExited(MouseEvent e) {
		tf1.setText("鼠标离开");
	}
	@Override
	public void mousePressed(MouseEvent e) {
	}
	@Override
	public void mouseReleased(MouseEvent e) {
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		String s="鼠标拖动";
		tf1.setText(s);
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		String s="鼠标移动";
		tf1.setText(s);
		tf2.setText("鼠标坐标为：X="+e.getX()+";Y="+e.getY());
	}
}
