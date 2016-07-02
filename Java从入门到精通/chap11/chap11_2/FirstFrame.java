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
		FirstFrame f=new FirstFrame("这是第一个Frame");
		f.setSize(300, 200);//设置Frame的大小，缺省为（0，0）
		f.setBackground(Color.BLUE);//设置Frame的背景，缺省为红色
		f.setVisible(true);//设置Frame为课件，缺省为不可见
		f.addWindowListener(f.new Mywindowadapter());//为窗口f添加监听器
	}
	//实现窗口的关闭功能
	class Mywindowadapter extends WindowAdapter{
		public void windowClosing(WindowEvent we){//覆盖WindowAdapter方法
			System.exit(0);//程序退出
		}
	}
}
