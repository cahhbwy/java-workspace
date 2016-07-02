package chap13_4;

import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JProgressBar;

@SuppressWarnings("serial")
public class JProgressBarDemo extends JFrame{
	JProgressBar progress=new JProgressBar();
	int count=0;
	class Task extends TimerTask{
		public void run(){
			progress.setValue(count++);
		}
	}
	public JProgressBarDemo(){
		progress.setStringPainted(true);
		this.getContentPane().add(progress,"North");
		Task task=new Task();
		Timer timer=new Timer();
		timer.schedule(task, 100,100);
		this.setSize(500,100);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void excute(){
	}
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		JProgressBarDemo p=new JProgressBarDemo();
	}

}
