package chap12_2;

import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Choice;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.List;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

@SuppressWarnings("serial")
public class ItemEventDeme extends Frame implements ItemListener{
	public ItemEventDeme(){
		super();
		init();
	}
	public static void main(String[] args) {
		new ItemEventDeme();
	}
	List list;
	Checkbox checkbox1,checkbox2,checkbox3;
	Choice colorChooser;
	TextArea textarea;
	public void init(){
		setLayout(new GridLayout(4,1));
		textarea=new TextArea();
		add(textarea);
		list =new List(4,false);
		list.add("语文");
		list.add("数学");
		list.add("英语");
		list.add("物理");
		list.add("化学");
		list.add("历史");
		list.add("地理");
		add(list);
		list.addItemListener(this);
		Panel panel=new Panel();
		CheckboxGroup cbg=new CheckboxGroup();
		checkbox1=new Checkbox("one",cbg,true);
		checkbox1.addItemListener(this);
		panel.add(checkbox1);
		checkbox2=new Checkbox("two",cbg,false);
		checkbox2.addItemListener(this);
		panel.add(checkbox2);
		checkbox3=new Checkbox("three",cbg,false);
		checkbox3.addItemListener(this);
		panel.add(checkbox3);
		add(panel);
		colorChooser=new Choice();
		colorChooser.add("Green");
		colorChooser.add("Red");
		colorChooser.add("Blue");
		colorChooser.addItemListener(this);
		add(colorChooser);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent evt){
				setVisible(false);
				dispose();
				System.exit(0);
			}
		});
		setSize(200,300);
		setVisible(true);
	}
	public void itemStateChanged(ItemEvent eve) {
		if(eve.getSource()==list){
			textarea.setText(list.getSelectedItem());
		}
		if(eve.getSource()==checkbox1){
			textarea.setText(checkbox1.getLabel());
		}
		if(eve.getSource()==checkbox2){
			textarea.setText(checkbox2.getLabel());
		}
		if(eve.getSource()==checkbox3){
			textarea.setText(checkbox3.getLabel());
		}
		if(eve.getSource()==colorChooser){
			textarea.setText(colorChooser.getSelectedItem());
		}
	}
	
}
