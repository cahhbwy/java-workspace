package chap10_4;

class ShareDate{
	public String szDate="";
}
class ThreadDemo5 extends Thread{
	private ShareDate oShare;
	ThreadDemo5() {}
	ThreadDemo5(String szName,ShareDate oShare){
		super(szName);
		this.oShare=oShare;
	}
	public void run(){
		for(int i=0;i<5;i++){
			if(this.getName().equals("Thread1")){
				oShare.szDate="这是第1个线程";
				try {
					Thread.sleep((int)Math.random()*100);
				} catch (InterruptedException e) {
				}
				System.out.println(this.getName()+":"+oShare.szDate);
			}
			else if(this.getName().equals("Thread2")){
				oShare.szDate="这是第2个线程";
				try {
					Thread.sleep((int)Math.random()*100);
				} catch (InterruptedException e) {
				}
				System.out.println(this.getName()+":"+oShare.szDate);
			}
		}
	}
}
public class ThreadNoSynchronized {

	public static void main(String[] args) {
		ShareDate oShare=new ShareDate();
		ThreadDemo5 th1= new ThreadDemo5("Thread1",oShare);
		ThreadDemo5 th2= new ThreadDemo5("Thread2",oShare);
		th1.start();
		th2.start();
	}

}
