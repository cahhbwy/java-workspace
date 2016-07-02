package chap13_1;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;

public class SwingApplication {

	public static void main(String[] args) {
		try{
			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
		}catch(Exception e){
			e.printStackTrace();
		}
		JFrame frame=new JFrame("Swing应用程序");
		Container c=frame.getContentPane();
		JPanel panel=new JPanel();
		c.add(panel);
		panel.setLayout(new FlowLayout());
		final JLabel label=new JLabel();
		JButton button=new JButton("Click me!");
		panel.add(label);
		panel.add(button);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				label.setText("北京欢迎您！");
			}
		});
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
		frame.setSize(300,240);
		frame.setVisible(true);
	}

}
