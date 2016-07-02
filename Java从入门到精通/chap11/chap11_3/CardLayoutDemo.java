package chap11_3;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

@SuppressWarnings("serial")
public class CardLayoutDemo extends Frame implements MouseListener{
	private Button first=new Button("第一页");
	private Button second=new Button("第二页");
	private Button third=new Button("第三页");
	private Panel cards=new Panel();
	private CardLayout cl=new CardLayout();
	public CardLayoutDemo(String string){
		super(string);
		init();
	}
	public static void main(String[] args) {
		new CardLayoutDemo("CardLayout1");
	}
	public void init(){
		setLayout(new BorderLayout());//设置窗口的布局管理器为BorderLayout
		setSize(400,300);//设置窗口的大小
		Panel p=new Panel();//创建并初始化面板Panel对象p
		p.setLayout(new FlowLayout());//设置面板p的布局管理器为FlowLayout
		first.addMouseListener(this);//为first按钮添加鼠标监听器
		second.addMouseListener(this);//为second按钮添加鼠标监听器
		third.addMouseListener(this);//为third按钮添加鼠标监听器
		p.add(first);//在面板p中添加按钮first
		p.add(second);//在面板p中添加按钮second
		p.add(third);//在面板p中添加按钮third
		add("North",p);//在窗口中添加面板p
		cards.setLayout(cl);//设置panel为卡片布局器
		cards.add("First card",new Button("第一页内容"));//在cards中添加按钮
		cards.add("second card",new Button("第二页内容"));//在cards中添加按钮
		cards.add("Third card",new Button("第三页内容"));//在cards中添加按钮
		add("Center",cards);//将cards添加到窗口的Center位置
		addWindowListener(new WindowAdapter() {//注册监听器，关闭功能
			public void windowClosing(WindowEvent evt){//实现windowClosing方法
				setVisible(false);//设置窗口f不可见
				dispose();//释放窗口极其子组件的屏幕资源
				System.exit(0);//退出程序
			}
		});
		setVisible(true);//显示窗口
	}
	public void mouseClicked(MouseEvent evt){//实现监听器方法
		if(evt.getSource()==first){//当事件源为first时
			cl.first(cards);//翻转到第一张卡片
		}
		else if(evt.getSource()==second){//当事件源为second时
			cl.first(cards);//翻转到第一张卡片
			cl.next(cards);//翻转到下一张卡片
		}
		else if(evt.getSource()==third){//当事件源为third时
			cl.last(cards);//翻转到最后一张卡片
		}
	}
	public void mouseEntered(MouseEvent e) {//空方法
	}
	public void mouseExited(MouseEvent e) {//空方法
	}
	public void mousePressed(MouseEvent e) {//空方法
	}
	public void mouseReleased(MouseEvent e) {//空方法
	}
	
}
