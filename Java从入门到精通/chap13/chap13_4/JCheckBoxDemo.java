package chap13_4;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class JCheckBoxDemo extends JPanel implements ActionListener{

	public static void main(String[] args) {
		JFrame jf=new JFrame();
		JCheckBoxDemo bi=new JCheckBoxDemo();
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
	
	public JCheckBoxDemo(){
		super();
		this.setLayout(new GridLayout(2,1));
		button=new JCheckBox[3];
		imageIcon=new ImageIcon[6];
		ftf=new JTextField(20);
		panel=new JPanel();
		add(ftf);
		imageIcon[0]=new ImageIcon("images\\Cat1.jpg");
		imageIcon[1]=new ImageIcon("images\\Rabbit1.jpg");
		imageIcon[2]=new ImageIcon("images\\Dog1.jpg");
		imageIcon[3]=new ImageIcon("images\\Cat.jpg");
		imageIcon[4]=new ImageIcon("images\\Rabbit.jpg");
		imageIcon[5]=new ImageIcon("images\\Dog.jpg");
		button[0]=new JCheckBox("รจ",imageIcon[0]);
		button[1]=new JCheckBox("อร",imageIcon[1]);
		button[2]=new JCheckBox("นท",imageIcon[2]);
		panel.add(button[0]);
		panel.add(button[1]);
		panel.add(button[2]);
		add(panel);
		button[0].addActionListener(this);
		button[1].addActionListener(this);
		button[2].addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		String select="";
		for(int i=0;i<button.length;i++){
			if(button[i].isSelected()){
				select=select+(i==0?"รจ":i==1?"อร":"นท");
				button[i].setIcon(imageIcon[i+3]);
			}else{
				button[i].setIcon(imageIcon[i]);
			}
		}
		ftf.setText(select);
	}
	
	JCheckBox button[];
	ImageIcon imageIcon[];
	JTextField ftf;
	JPanel panel;
}
