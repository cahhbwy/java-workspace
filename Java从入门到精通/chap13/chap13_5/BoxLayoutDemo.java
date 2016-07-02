package chap13_5;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;

public class BoxLayoutDemo {

	public static void main(String[] args) {
		JFrame f=new JFrame("BoxLayout ÑÝÊ¾³ÌÐò");
		f.setBounds(80, 60, 300, 230);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		int SIZE=3;
		Container c=f.getContentPane();
		c.setLayout(new BorderLayout(30, 30));
		Box boxes[]=new Box[4];
		boxes[0]=Box.createHorizontalBox();
		boxes[1]=Box.createVerticalBox();
		boxes[2]=Box.createHorizontalBox();
		boxes[3]=Box.createVerticalBox();
		for(int i=0;i<SIZE;i++)
			boxes[0].add(new JButton("boxes[0]["+i+"]"));
		for(int i=0;i<SIZE;i++)
			boxes[1].add(new JButton("boxes[1]["+i+"]"));
		for(int i=0;i<SIZE;i++)
			boxes[2].add(new JButton("boxes[2]["+i+"]"));
		for(int i=0;i<SIZE;i++)
			boxes[3].add(new JButton("boxes[3]["+i+"]"));
		c.add(boxes[0],BorderLayout.NORTH);
		c.add(boxes[1],BorderLayout.EAST);
		c.add(boxes[2],BorderLayout.SOUTH);
		c.add(boxes[3],BorderLayout.WEST);
		f.setVisible(true);
	}

}
