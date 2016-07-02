package chap10_2;

public class ThreadSleep {

	public static void main(String[] args) {
		SubThread2 st=new SubThread2("SubThread");
		st.start();
	}

}
class SubThread2 extends Thread{
	SubThread2(){}
	SubThread2(String Name){
		super(Name);
	}
	public void run(){
		for(int count=1,row=1;row<10;row++,count++){
			for(int i=0;i<count;i++){
				System.out.print('*');
			}
			try{
				System.out.print("\t wait......");
				Thread.sleep(1000);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
			System.out.println();
		}
	}
}