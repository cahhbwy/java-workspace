package chap11_3;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class NestedContainer {
	private Frame f;
	private Panel pn, p;
	private Button bw;
	private Button bo, bc;

	public static void main(String[] args) {
		new NestedContainer().show();
	}

	public void show() {
		f = new Frame("����Ƕ��ʹ��");
		bo = new Button("��");
		bc = new Button("�ر�");
		pn = new Panel();
		pn.setBackground(Color.green);
		pn.add(bo);
		pn.add(bc);
		f.add(pn, "North");
		bw = new Button("����");
		f.add(bw, "West");
		p = new Panel();
		p.setBackground(Color.red);
		f.add(p, "Center");
		f.setSize(400, 300);
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent evt) {
				f.setVisible(false);
				f.dispose();
				System.exit(0);
			}
		});
		f.setVisible(true);
	}
}
