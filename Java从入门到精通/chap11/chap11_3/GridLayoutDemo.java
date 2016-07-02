package chap11_3;

import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GridLayoutDemo {
	private Frame f;
	private Button b1,b2,b3,b4,b5,b6;
	public GridLayoutDemo(){
		b1=new Button("[0][0]");
		b2=new Button("[0][1]");
		b3=new Button("[0][2]");
		b4=new Button("[1][0]");
		b5=new Button("[1][1]");
		b6=new Button("[1][2]");
	}
	public static void main(String[] args) {
		GridLayoutDemo fl=new GridLayoutDemo();
		fl.show();
	}
	public void show(){
		f=new Frame("GridLayout˳�򲼾�");
		f.setSize(400,300);
		f.setLayout(new GridLayout(2,3));
		f.add(b1);
		f.add(b2);
		f.add(b3);
		f.add(b4);
		f.add(b5);
		f.add(b6);
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent evt){
				f.setVisible(false);//���ô���f���ɼ�
				f.dispose();//�ͷŴ��ڼ������������Ļ��Դ
				System.exit(0);//�˳�����
			}
		});
		//�������У��������൱��setSize()�����ô��ھ���С��С���ո��ܹ�����סb1��b2������ť
		f.pack();
		f.setVisible(true);
	}
}
