package chap11_3;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FlowLayoutDemo {
	private Frame f;
	private Button b1,b2,b3;
	public FlowLayoutDemo(){
		b1=new Button("����");
		b2=new Button("ȡ��");
		b3=new Button("ȷ��");
	}
	public static void main(String[] args) {
		FlowLayoutDemo fl=new FlowLayoutDemo();
		fl.show();
	}
	public void show(){
		f=new Frame("FlowLayout˳�򲼾�");
		f.setSize(300,240);
		f.setLayout(new FlowLayout(FlowLayout.CENTER,30,20));
		f.add(b1);
		f.add(b2);
		f.add(b3);
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
