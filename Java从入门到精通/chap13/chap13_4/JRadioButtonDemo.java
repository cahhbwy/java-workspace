package chap13_4;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class JRadioButtonDemo extends JPanel implements ActionListener{

	public static void main(String[] args) {
		JFrame jf=new JFrame();
		JRadioButtonDemo bi=new JRadioButtonDemo();
		jf.getContentPane().add(bi);
		jf.setSize(500,230);
		jf.setVisible(true);
		jf.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
		jf.pack();
	}
	public JRadioButtonDemo(){
		super();
		this.setLayout(new GridLayout(2,1));
		button=new JRadioButton[2];
		imageIcon=new ImageIcon[4];
		ftf=new JTextField(20);
		panel=new JPanel();
		add(ftf);
		imageIcon[0]=new ImageIcon("images\\male0.gif");
		imageIcon[1]=new ImageIcon("images\\female0.gif");
		imageIcon[2]=new ImageIcon("images\\male.gif");
		imageIcon[3]=new ImageIcon("images\\female.gif");
		button[0]=new JRadioButton(imageIcon[0]);
		button[1]=new JRadioButton(imageIcon[1]);
		panel.add(button[0]);
		panel.add(button[1]);
		add(panel);
		button[0].addActionListener(this);
		button[1].addActionListener(this);
	}
	@SuppressWarnings("unused")
	@Override
	public void actionPerformed(ActionEvent e) {
		ImageIcon imageIconc;
		String select="";
		for(int i=0;i<button.length;i++){
			if(button[i].isSelected()){
				select=select+(i==0?"ÄÐ":"Å®");
				button[i].setIcon(imageIcon[i+2]);
			}else {
				button[i].setIcon(imageIcon[i]);
			}
		}
		ftf.setText(select);
	}
	
	JRadioButton button[];
	ImageIcon imageIcon[];
	ButtonGroup bg;
	JTextField ftf;
	JPanel panel;
}
