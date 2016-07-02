package chap11_5;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

@SuppressWarnings("serial")
public class GraphicsDemo extends Frame{
	private int cx;
	private int cy;
	public static void main(String[] args) {
		GraphicsDemo f=new GraphicsDemo("Graphics»æÍ¼");
		f.setSize(500,300);
		f.setVisible(true);
	}
	public void paint(Graphics g){
		setXY();
		Point p=new Point(cx/2, cy/2);
		g.drawLine(0, 0, cx, cy);
		g.draw3DRect(cx/2, cy/2, cx/3, cy/3, false);
		Rectangle rect=new Rectangle((p.x-40),(p.y-40),80,40);
		int[] xP={(p.x-40),(p.x+90),(p.x+200),(p.x-40)};
		int[] yP={(p.y-40),(p.y+140),(p.y+60),(p.y-40)};
		g.drawArc(rect.x, rect.y, rect.width, rect.height*2, 270, 90);
		g.drawPolygon(xP, yP, 3);
	}
	private void setXY() {
		Dimension d=getSize();
		cx=d.width/2;
		cy=d.height/2;
	}
	public GraphicsDemo(String str){
		super(str);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent evt){
				setVisible(false);
				dispose();
				System.exit(0);
			}
		});
	}
}
