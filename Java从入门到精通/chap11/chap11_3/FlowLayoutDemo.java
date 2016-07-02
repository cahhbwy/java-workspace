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
		b1=new Button("继续");
		b2=new Button("取消");
		b3=new Button("确定");
	}
	public static void main(String[] args) {
		FlowLayoutDemo fl=new FlowLayoutDemo();
		fl.show();
	}
	public void show(){
		f=new Frame("FlowLayout顺序布局");
		f.setSize(300,240);
		f.setLayout(new FlowLayout(FlowLayout.CENTER,30,20));
		f.add(b1);
		f.add(b2);
		f.add(b3);
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent evt){
				f.setVisible(false);//设置窗口f不可见
				f.dispose();//释放窗口极其子组件的屏幕资源
				System.exit(0);//退出程序
			}
		});
		//紧凑排列，其作用相当于setSize()，即让窗口尽量小，小到刚刚能够包容住b1、b2两个按钮
		f.pack();
		f.setVisible(true);
	}
}
