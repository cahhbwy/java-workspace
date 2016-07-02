package chap11_3;

import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Component;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

@SuppressWarnings("serial")
public class GridBagLayoutDemo extends Frame{
	Label l1,l2,l3,l4;
	TextField tf1,tf2,tf3;
	Button btn1,btn2;
	CheckboxGroup cbg;
	Checkbox cb1,cb2,cb3,cb4;
	GridBagLayout gb;
	GridBagConstraints gbc;
	public GridBagLayoutDemo(String title){
		super(title);
		l1=new Label("用户名");
		l2=new Label("密码");
		l3=new Label("重复密码");
		l4=new Label("获取途径");
		tf1=new TextField(20);
		tf2=new TextField(20);
		tf3=new TextField(20);
		gb=new GridBagLayout();
		setLayout(gb);//设置窗口布局器gb
		gbc=new GridBagConstraints();//初始化网格包容器
		Panel p=new Panel();//创建并初始化面板panel
		cbg=new CheckboxGroup();//初始化多选框组checkboxgroup
		cb1=new Checkbox("搜索",cbg,false);
		cb2=new Checkbox("广告",cbg,false);
		cb3=new Checkbox("朋友",cbg,false);
		cb4=new Checkbox("其他",cbg,false);
		p.add(cb1);
		p.add(cb2);
		p.add(cb3);
		p.add(cb4);
		btn1=new Button("提交");
		btn2=new Button("重置");
		Panel p1=new Panel();
		p1.add(btn1);
		p1.add(btn2);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
		gbc.fill=GridBagConstraints.HORIZONTAL;//设置gbc的fill域
		addComponent(l1,0,0,1,1);
		addComponent(tf1,0,2,1,1);
		addComponent(l2,1,0,1,1);
		addComponent(tf2,1,2,1,1);
		addComponent(l3,2,0,1,1);
		addComponent(tf3,2,2,1,1);
		addComponent(l4,3,0,1,1);
		addComponent(p,3,2,1,1);
		addComponent(p1,4,2,1,1);
	}
	public void addComponent(Component c,int row,int col,int nrow,int ncol){
		gbc.gridy=row;//设置组件显示区域的顶端单元格
		gbc.gridx=col;//设置组件显示区域的开始边单元格
		gbc.gridwidth=nrow;//设置组件显示区域一列的单元格数
		gbc.gridheight=ncol;//设置组件显示区域一列的单元格数
		gb.setConstraints(c, gbc);//设置布局的约束条件
		add(c);//组件c添加到容器中
	}
	public static void main(String[] args) {
		GridBagLayoutDemo mygb=new GridBagLayoutDemo("网格包布局管理器");
		mygb.setSize(300,200);
		mygb.setVisible(true);
	}

}
