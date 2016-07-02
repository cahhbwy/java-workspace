package chap10_2;

class WaitThreadStop extends Thread {
	String szName;
	WaitThreadStop(String szName){
		this.szName=szName;
	}
	public void run(){
		System.out.println(szName);
		for(int count=1,row=1;row<10;row++,count++){
			for(int i=0;i<count;i++){
				System.out.print(count);
			}
			System.out.println();
		}
	}
}

public class WaitThreadStopMain {

	public static void main(String[] args) {
		WaitThreadStopMain test=new WaitThreadStopMain();
//		test.Method1();
		test.Method2();
	}
	public void Method1(){
		WaitThreadStop th1=new WaitThreadStop("th1");
		WaitThreadStop th2=new WaitThreadStop("th2");
		th1.start();
		while(th1.isAlive()){
			try{
				Thread.sleep(100);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
		th2.start();
	}
	public void Method2(){
		WaitThreadStop th1=new WaitThreadStop("th1");
		WaitThreadStop th2=new WaitThreadStop("th2");
		WaitThreadStop th3=new WaitThreadStop("th3");
		
		th1.start();
		try{
			th1.join();
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		th2.start();
		try {
			th2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		th3.start();
	}

}
