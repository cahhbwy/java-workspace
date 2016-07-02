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
		Menu menu=new Menu("�ļ�");
		menu.add("�½�");
		menu.add("��");
		menu.add("�ر�");
		menu.add("�˳�");
		Menu irons=new Menu("�༭");
		irons.add("��д");
		irons.add("����");
		irons.add("ɾ��");
		irons.add("����");
		irons.add("����");
		irons.addSeparator();
		irons.add("ȡ��");
		irons.insert("ճ��", 2);
		MenuBar mb=new MenuBar();
		mb.add(menu);
		mb.add(irons);
		setMenuBar(mb);
		pop=new PopupMenu("menu");
		pop.add("�½�");
		pop.add("ճ��");
		pop.add("ȡ��");
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
		new MenuDemo("�˵���ʾ").setVisible(true);
	}

}
