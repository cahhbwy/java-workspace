package chap11_2;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

@SuppressWarnings("serial")
public class FrameaddedPanel extends Frame{
	public FrameaddedPanel(String str){
		super(str);
	}
	public static void main(String[] args) {
		FrameaddedPanel f=new FrameaddedPanel("��Frame�����Panel");//��������ʼ��FrameaddedPanel����f
		Panel p =new Panel();//��������ʼ��Panel����p
		f.setSize(400,300);//���ô��ڴ�С
		f.setBackground(Color.BLUE);//���f�ı�����ɫ����Ϊ��ɫ
		f.setLayout(null);//ȡ�����ֹ�����
		p.setSize(200,200);//�������p�Ĵ�С
		p.setBackground(Color.RED);//�������p����ɫΪ��ɫ
		f.add(p);//��add���������p��ӵ����f��
		f.setVisible(true);//��ʾ����f
		f.addWindowListener(f.new Mywindowadapter());//����¼�������
	}
	class Mywindowadapter extends WindowAdapter{
		public void windowClosing(WindowEvent we){
			System.exit(0);
		}
	}
}
