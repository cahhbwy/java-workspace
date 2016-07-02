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
		FrameaddedPanel f=new FrameaddedPanel("在Frame中添加Panel");//创建并初始化FrameaddedPanel对象f
		Panel p =new Panel();//创建并初始化Panel对象p
		f.setSize(400,300);//设置窗口大小
		f.setBackground(Color.BLUE);//框架f的背景颜色设置为红色
		f.setLayout(null);//取消布局管理器
		p.setSize(200,200);//设置面板p的大小
		p.setBackground(Color.RED);//设置面版p的颜色为红色
		f.add(p);//用add方法把面板p添加到框架f中
		f.setVisible(true);//显示窗口f
		f.addWindowListener(f.new Mywindowadapter());//添加事件处理方法
	}
	class Mywindowadapter extends WindowAdapter{
		public void windowClosing(WindowEvent we){
			System.exit(0);
		}
	}
}
