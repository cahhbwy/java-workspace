package chap12_4;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Panel;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AdapterDemo {
	private Frame f;
	Point start,end;
	Panel panel;
	public static void main(String[] args) {
		new AdapterDemo();
	}
	public AdapterDemo(){
		f=new Frame("请单击或拖动鼠标");
		panel=new Panel();
		f.add("Center",panel);
		panel.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e){
				start=e.getPoint();
				System.out.println(start);
			}
			public void mouseReleased(MouseEvent e){
				end=e.getPoint();
				System.out.println(end);
				Graphics g=panel.getGraphics();
				panel.paint(g);
				g.drawLine(start.x, start.y, end.x, end.y);
			}
		});
		f.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(1);
			}
		});
		f.setSize(400,300);
		f.setVisible(true);
	}
}
