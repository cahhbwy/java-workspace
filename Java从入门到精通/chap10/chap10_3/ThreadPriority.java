package chap10_3;
class InheritThread extends Thread{
	public void run(){
		System.out.println("InheritTread is running...");
		for(int i=0;i<10;i++){
			System.out.println(" InheritThread:i="+i);
			try{
				Thread.sleep((int)Math.random()*1000);
			}catch(InterruptedException e){
			}
		}
	}
}
class RunnableThread implements Runnable{
	public void run(){
		System.out.println("RunnableThread is running...");
		for(int i=0;i<10;i++){
			System.out.println("RunnableThread:i="+i);
			try{
				Thread.sleep((int)Math.random()*1000);
			}catch(InterruptedException e){
			}
		}
	}
}
public class ThreadPriority {

	public static void main(String[] args) {
		InheritThread itd=new InheritThread();
		Thread rtd=new Thread(new RunnableThread());
		itd.setPriority(10);
		rtd.setPriority(1);
		itd.start();
		rtd.start();
	}

}
