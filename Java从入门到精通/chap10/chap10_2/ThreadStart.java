package chap10_2;

public class ThreadStart {

	public static void main(String[] args) {
		Runnable r=new RunnableThread();
		Thread rt=new Thread(r);
		rt.start();
		SubThread st=new SubThread("SubThread");
		st.start();
	}
	
}
class RunnableThread implements Runnable{
	public void run(){
		System.out.println("RunnableThread����");
	}
}
class SubThread extends Thread{
	SubThread(){}
	SubThread(String Name){
		super(Name);
	}
	public void run(){
		System.out.println("SubThread����");
	}
}