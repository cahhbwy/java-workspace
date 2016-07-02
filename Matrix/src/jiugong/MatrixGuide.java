package jiugong;

import java.awt.*;
import java.awt.event.*;

public class MatrixGuide implements AdjustmentListener, ItemListener{
	static MatrixGuide matrixGuide;
	static Runnable game;
	static Thread gamerun;
	Frame framest;
	Frame frameend;
	Label lb1,lb2,lb3,lb4,lb5,lb6;
	Panel p1,p2,p3;
	TextField tf;
	Scrollbar sb;
	CheckboxGroup cbg;
	Checkbox cb1,cb2;
	Button btn,btny,btnn;
	int size;
	boolean control;
	
	public MatrixGuide(){
		size=3;
		control=true;
		init();
	}
	public void init(){
		size=3;
		framest=new Frame("Matrix");
		lb1=new Label("wasd or 8456操作");
		lb2=new Label("空格查找");
		lb3=new Label("“h”自动/手动");
		p1=new Panel();
		lb4=new Label("边长");
		tf=new TextField("3",5);
		sb=new Scrollbar(Scrollbar.HORIZONTAL,3,1,3,21);
		sb.addAdjustmentListener(this);
		tf.setEditable(false);
		p2=new Panel();
		lb5=new Label("操作模式");
		cbg=new CheckboxGroup();
		cb1=new Checkbox("顺向",cbg,true);
		cb1.addItemListener(this);
		cb2=new Checkbox("逆向",cbg,false);
		btn=new Button("确定");
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				framest.setVisible(false);
				framest.dispose();
				game=new Game(size,control);
				gamerun=new Thread(game);
				gamerun.start();
			}
		});
		framest.setLayout(new GridLayout(7, 1));
		framest.add(lb1);
		framest.add(lb2);
		framest.add(lb3);
		p1.add(lb4);
		p1.add(tf);
		framest.add(p1);
		framest.add(sb);
		p2.add(lb5);
		p2.add(cb1);
		p2.add(cb2);
		framest.add(p2);
		framest.add(btn);
		framest.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent eve){
				framest.setVisible(false);
				framest.dispose();
				System.exit(0);
			}
		});
		framest.pack();
		framest.setVisible(true);
		framest.setLocationRelativeTo(null);
		framest.setResizable(false);
		
		lb6=new Label("是否重新开始");
		btny=new Button("是");
		btnn=new Button("否");
		frameend=new Frame();
		frameend.setLayout(new GridLayout(2,1));
		p3=new Panel();
		p3.add(btny);
		p3.add(btnn);
		frameend.add(lb6);
		frameend.add(p3);
		btny.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frameend.setVisible(false);
				frameend.dispose();
				framest.setVisible(true);
			}
		});
		btnn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frameend.setVisible(false);
				frameend.dispose();
				System.exit(0);
			}
		});
		frameend.setVisible(false);
		frameend.pack();
		frameend.setLocationRelativeTo(null);
	}
	public void adjustmentValueChanged(AdjustmentEvent e) {
		tf.setText(Integer.toString(((Scrollbar) e.getSource()).getValue()));
		size=((Scrollbar) e.getSource()).getValue();
	}
	public void itemStateChanged(ItemEvent eve) {
		if(eve.getSource()==cb1)
			control=false;
		if(eve.getSource()==cb2)
			control=true;
	}

	public static void main(String[] args){
		matrixGuide=new MatrixGuide();
	}
	public void run() {
		while (true) {
			Num num = new Num(size);
			num.start();
			num.draw(-1);
			if (control) {
				while (true) {
					char c = 'p';
					if (StdDraw.hasNextKeyTyped()) {
						c = StdDraw.nextKeyTyped();
						switch (c) {
						case 'w': case '8': num.move(8); break;
						case 'a': case '4': num.move(4); break;
						case 's': case '5': num.move(2); break;
						case 'd': case '6': num.move(6); break;
						case ' ': num.search(); break;
						case 'h': num.auto();break;
						default: num.move(5); break;
						}
						num.draw(-1);
					}
					if (num.win()) {
						break;
					}
				}
			} else {
				while (true) {
					char c = 'p';
					if (StdDraw.hasNextKeyTyped()) {
						c = StdDraw.nextKeyTyped();
						switch (c) {
						case 'w': case '8': num.move(2); break;
						case 'a': case '4': num.move(6); break;
						case 's': case '5': num.move(8); break;
						case 'd': case '6': num.move(4); break;
						case ' ': num.search(); break;
						case 'h': num.auto();break;
						default: num.move(5); break;
						}
						num.draw(-1);
						if (num.win()) {
							break;
						}
					}
				}
			}
			StdDraw.show(500);
			StdDraw.clear();
			StdDraw.text((size - 1.0) / 2, (size - 1.0) / 2, "YOU WIN!!!  "
					+ num.step + " step");
			StdDraw.show();
			frameend.setVisible(true);
		}
	}

}
