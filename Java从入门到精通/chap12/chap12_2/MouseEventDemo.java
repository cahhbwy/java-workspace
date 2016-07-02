package chap12_2;

import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

@SuppressWarnings("serial")
public class MouseEventDemo extends Frame{
	public MouseEventDemo(){
		super();
		init();
	}
	public static void main(String[] args) {
		new MouseEventDemo();
	}
	Panel panel;
	TextField textField1,textField2;
	public void init(){
		setLayout(new GridLayout(3,1));
		textField1=new TextField();
		textField2=new TextField();
		add(textField1);
		add(textField2);
		panel=new Panel();
		panel.setBackground(Color.cyan);
		add(panel);
		panel.addMouseListener(new MouseListener() {
			public void mouseReleased(MouseEvent eve) {
				textField1.setText("鼠标松开");
			}
			public void mousePressed(MouseEvent eve) {
				textField1.setText("鼠标按下");
			}
			public void mouseExited(MouseEvent eve) {
				textField1.setText("鼠标离开面板区域");
			}
			public void mouseEntered(MouseEvent eve) {
				textField1.setText("鼠标进入面板区域");
			}
			public void mouseClicked(MouseEvent eve) {
				textField2.setText("X="+eve.getX()+";Y="+eve.getY());
			}
		});
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent evt){
				setVisible(false);
				dispose();
				System.exit(0);
			}
		});
		setSize(200,200);
		setVisible(true);
	}
}
