package chap11_2;

import java.awt.Color;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

@SuppressWarnings("serial")
public class FirstFrame extends Frame{
	public FirstFrame(String string){
		super(string);
	}
	public static void main(String[] args){
		FirstFrame f=new FirstFrame("���ǵ�һ��Frame");
		f.setSize(300, 200);//����Frame�Ĵ�С��ȱʡΪ��0��0��
		f.setBackground(Color.BLUE);//����Frame�ı�����ȱʡΪ��ɫ
		f.setVisible(true);//����FrameΪ�μ���ȱʡΪ���ɼ�
		f.addWindowListener(f.new Mywindowadapter());//Ϊ����f��Ӽ�����
	}
	//ʵ�ִ��ڵĹرչ���
	class Mywindowadapter extends WindowAdapter{
		public void windowClosing(WindowEvent we){//����WindowAdapter����
			System.exit(0);//�����˳�
		}
	}
}
