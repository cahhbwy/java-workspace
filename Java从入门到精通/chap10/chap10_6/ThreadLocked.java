package chap10_6;

public class ThreadLocked implements Runnable{
	public static boolean flag=true;
	private static Object A=new Object();
	private static Object B=new Object();

	public static void main(String[] args) throws InterruptedException{
		Runnable r1=new ThreadLocked();
		Thread t1=new Thread(r1);
		Runnable r2=new ThreadLocked();
		Thread t2=new Thread(r2);
		t1.start();
		t2.start();
	}
	public void AccessA(){
		flag=false;
		synchronized (A) {
			System.out.println("�߳�t1���ҵõ���A����");
			try{
				Thread.sleep(1000);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
			System.out.println("�߳�t1���һ���õ�B����");
			synchronized (B) {
				System.out.println("�߳�t1���ҵõ���B����");
			}
		}
	}
	public void AccessB(){
		flag=true;
		synchronized (B) {
			System.out.println("�߳�t2���ҵõ���B����");
			try{
				Thread.sleep(1000);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
			System.out.println("�߳�t2���һ���õ�A����");
			synchronized (A) {
				System.out.println("�߳�t2���ҵõ���A����");
			}
		}
	}
	public void run(){
		if(flag){
			AccessA();
		}
		else{
			AccessB();
		}
	}
}
