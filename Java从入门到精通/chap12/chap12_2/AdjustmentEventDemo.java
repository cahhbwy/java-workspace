package chap12_2;

import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Scrollbar;
import java.awt.TextField;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

@SuppressWarnings("serial")
public class AdjustmentEventDemo extends Frame{
	Scrollbar slider;
	TextField value;
	Label label;
	public AdjustmentEventDemo(){
		super();
		init();
	}
	public static void main(String[] args) {
		new AdjustmentEventDemo();
	}
	public void init(){
		setLayout(new GridLayout(1,3));
		slider=new Scrollbar(Scrollbar.HORIZONTAL,0,1,0,101);
		slider.addAdjustmentListener(new AdjustmentEventHandler());
		value=new TextField("0",5);
		value.setEditable(false);
		label=new Label("0~100");
		label.setBackground(Color.cyan);
		add(label);
		add(slider);
		add(value);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent evt){
				setVisible(false);
				dispose();
				System.exit(0);
			}
		});
		setSize(300,60);
		setVisible(true);
	}
	class AdjustmentEventHandler implements AdjustmentListener{
		public void adjustmentValueChanged(AdjustmentEvent eve) {
			value.setText(Integer.toString(((Scrollbar)eve.getSource()).getValue()));
		}
		
	}
}
