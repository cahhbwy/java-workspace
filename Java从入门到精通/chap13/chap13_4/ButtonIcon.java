package chap13_4;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ButtonIcon extends JPanel implements ActionListener{

	public static void main(String[] args) {
		JFrame jf=new JFrame();
		ButtonIcon bi=new ButtonIcon();
		jf.getContentPane().add(bi);
		jf.setSize(400,130);
		jf.setVisible(true);
		jf.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
	}
	public ButtonIcon(){
		super();
		button=new JButton[3];
		imageIcon=new ImageIcon[3];
		imageIcon[0]=new ImageIcon("images\\first.gif");
		imageIcon[1]=new ImageIcon("images\\second.gif");
		imageIcon[2]=new ImageIcon("images\\third.gif");
		button[0]=new JButton(imageIcon[0]);
		button[1]=new JButton(imageIcon[1]);
		button[2]=new JButton(imageIcon[2]);
		add(button[0]);
		add(button[1]);
		add(button[2]);
		button[0].addActionListener(this);
		button[1].addActionListener(this);
		button[2].addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		ImageIcon imageIconc;
		if((JButton)e.getSource()==button[0]){
			for (int i = 0; i < 3; i++)
				button[i].setIcon(imageIcon[(i+1)%3]);
			imageIconc=imageIcon[0];
			imageIcon[0]=imageIcon[1];
			imageIcon[1]=imageIcon[2];
			imageIcon[2]=imageIconc;
			imageIconc=null;
		}else if((JButton)e.getSource()==button[2]){
			for(int i=2;i>=0;i--)
				button[i].setIcon(imageIcon[(i+2)%3]);
			imageIconc=imageIcon[2];
			imageIcon[2]=imageIcon[1];
			imageIcon[1]=imageIcon[0];
			imageIcon[0]=imageIconc;
			imageIconc=null;
		}
	}	
	
	JButton button[];
	ImageIcon imageIcon[];
}
