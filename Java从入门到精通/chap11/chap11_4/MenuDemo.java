package chap11_4;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.PopupMenu;
import java.awt.TextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

@SuppressWarnings("serial")
public class MenuDemo extends Frame{
	PopupMenu pop;
	public MenuDemo(String string){
		super(string);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent evt){
				setVisible(false);
				dispose();
				System.exit(0);
			}
		});
		setSize(400,300);
		Menu menu=new Menu("文件");
		menu.add("新建");
		menu.add("打开");
		menu.add("关闭");
		menu.add("退出");
		Menu irons=new Menu("编辑");
		irons.add("重写");
		irons.add("复制");
		irons.add("删除");
		irons.add("代替");
		irons.add("查找");
		irons.addSeparator();
		irons.add("取消");
		irons.insert("粘贴", 2);
		MenuBar mb=new MenuBar();
		mb.add(menu);
		mb.add(irons);
		setMenuBar(mb);
		pop=new PopupMenu("menu");
		pop.add("新建");
		pop.add("粘贴");
		pop.add("取消");
		final TextArea p=new TextArea(100,100);
		p.setBackground(Color.blue);
		p.add(pop);
		p.addMouseListener(new MouseAdapter() {
			public void mouseReleased(java.awt.event.MouseEvent evt){
				if(evt.isPopupTrigger()){
					System.out.println("popup Trigger");
					System.out.println(evt.getComponent());
					System.out.println(""+evt.getX()+" "+evt.getY());
					pop.show(p, evt.getX(), evt.getY());
				}
			}
		});
		this.add(p,BorderLayout.CENTER);
	}
	public static void main(String[] args) {
		new MenuDemo("菜单演示").setVisible(true);
	}

}
