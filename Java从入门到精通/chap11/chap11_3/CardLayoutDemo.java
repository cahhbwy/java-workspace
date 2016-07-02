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
	private Button first=new Button("��һҳ");
	private Button second=new Button("�ڶ�ҳ");
	private Button third=new Button("����ҳ");
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
		setLayout(new BorderLayout());//���ô��ڵĲ��ֹ�����ΪBorderLayout
		setSize(400,300);//���ô��ڵĴ�С
		Panel p=new Panel();//��������ʼ�����Panel����p
		p.setLayout(new FlowLayout());//�������p�Ĳ��ֹ�����ΪFlowLayout
		first.addMouseListener(this);//Ϊfirst��ť�����������
		second.addMouseListener(this);//Ϊsecond��ť�����������
		third.addMouseListener(this);//Ϊthird��ť�����������
		p.add(first);//�����p����Ӱ�ťfirst
		p.add(second);//�����p����Ӱ�ťsecond
		p.add(third);//�����p����Ӱ�ťthird
		add("North",p);//�ڴ�����������p
		cards.setLayout(cl);//����panelΪ��Ƭ������
		cards.add("First card",new Button("��һҳ����"));//��cards����Ӱ�ť
		cards.add("second card",new Button("�ڶ�ҳ����"));//��cards����Ӱ�ť
		cards.add("Third card",new Button("����ҳ����"));//��cards����Ӱ�ť
		add("Center",cards);//��cards��ӵ����ڵ�Centerλ��
		addWindowListener(new WindowAdapter() {//ע����������رչ���
			public void windowClosing(WindowEvent evt){//ʵ��windowClosing����
				setVisible(false);//���ô���f���ɼ�
				dispose();//�ͷŴ��ڼ������������Ļ��Դ
				System.exit(0);//�˳�����
			}
		});
		setVisible(true);//��ʾ����
	}
	public void mouseClicked(MouseEvent evt){//ʵ�ּ���������
		if(evt.getSource()==first){//���¼�ԴΪfirstʱ
			cl.first(cards);//��ת����һ�ſ�Ƭ
		}
		else if(evt.getSource()==second){//���¼�ԴΪsecondʱ
			cl.first(cards);//��ת����һ�ſ�Ƭ
			cl.next(cards);//��ת����һ�ſ�Ƭ
		}
		else if(evt.getSource()==third){//���¼�ԴΪthirdʱ
			cl.last(cards);//��ת�����һ�ſ�Ƭ
		}
	}
	public void mouseEntered(MouseEvent e) {//�շ���
	}
	public void mouseExited(MouseEvent e) {//�շ���
	}
	public void mousePressed(MouseEvent e) {//�շ���
	}
	public void mouseReleased(MouseEvent e) {//�շ���
	}
	
}
