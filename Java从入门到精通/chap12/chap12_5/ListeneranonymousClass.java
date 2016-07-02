package chap12_5;

import java.awt.Frame;
import java.awt.TextField;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ListeneranonymousClass {
	private Frame f;
	private TextField tf;
	public static void main(String[] args) {
		ListeneranonymousClass la=new ListeneranonymousClass();
		la.show();
	}
	public ListeneranonymousClass(){
		f=new Frame("监听器内部类，单击、移动鼠标");
		tf=new TextField(20);
	}
	public void show(){
		f.add(tf,"North");
		f.setSize(300,240);
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent evt){
				f.setVisible(false);
				f.dispose();
				System.out.println("退出！");
				System.exit(0);
			}
		});
		f.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseMoved(MouseEvent e){
				tf.setText("鼠标坐标：X="+e.getX()+";Y="+e.getY());
			}
		});
		f.setVisible(true);
	}
}
