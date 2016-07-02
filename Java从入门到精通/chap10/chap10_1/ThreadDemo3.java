package chap10_1;

public class ThreadDemo3 implements Runnable{
	//ÖØÔØrunº¯Êı
	public void run(){
		for(int count=1,row=1;row<10;row++,count++){
			for(int i=0;i<count;i++){
				System.out.print('*');
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		Runnable rb=new ThreadDemo3();
		Thread td=new Thread(rb);
		td.start();
	}

}
