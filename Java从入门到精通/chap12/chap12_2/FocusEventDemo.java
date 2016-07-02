package chap12_2;

import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

@SuppressWarnings("serial")
public class FocusEventDemo extends Frame{
	public FocusEventDemo(){
		super();
		init();
	}
	public static void main(String[] args) {
		new FocusEventDemo();
	}
	TextArea textarea;
	TextField textfield;
	public void init(){
		setLayout(new GridLayout(2,1));
		textarea=new TextArea();
		textarea.addFocusListener(new FocusListener() {
			public void focusLost(FocusEvent e) {
				textarea.setText("textarea:失去焦点");
			}
			public void focusGained(FocusEvent e) {
				textarea.setText("textarea:获得焦点");
			}
		});
		textfield=new TextField();
		textfield.addFocusListener(new FocusListener() {
			public void focusLost(FocusEvent e) {
				textfield.setText("textfield:失去焦点");
			}
			public void focusGained(FocusEvent e) {
				textfield.setText("textfield:获得焦点");
			}
		});
		add(textarea);
		add(textfield);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent evt){
				setVisible(false);
				dispose();
				System.exit(0);
			}
		});
		setSize(300,200);
		setVisible(true);
	}
}
