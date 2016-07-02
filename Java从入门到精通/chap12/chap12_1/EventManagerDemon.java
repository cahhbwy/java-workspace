package chap12_1;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class EventManagerDemon {

	public static void main(String[] args) {
		final Frame f=new Frame("Test");
		Button b=new Button("Press Me!");
		b.addActionListener(new ButtonHandler());
		f.setLayout(new FlowLayout());
		f.add(b);
		f.setSize(200,100);
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent evt){
				f.setVisible(false);
				f.dispose();
				System.exit(0);
			}
		});
		f.setVisible(true);
	}
	
}
class ButtonHandler implements ActionListener{
	public void actionPerformed(ActionEvent e){
		System.out.println("事件发生，已经捕获到");
	}
}