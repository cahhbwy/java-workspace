package chap10_1;

public class ThreadDemo1 extends Thread{
	//声明 ThreadDemo1 的构造方法
	ThreadDemo1(){}
	//声明 ThreadDemo1 带参数的构造方法
	ThreadDemo1(String szName){
		super(szName);
	}
	//重载 run 函数
	public void run(){
		for(int count=1,row=1;row<10;row++,count++){
			for(int i=0;i<count;i++){
				System.out.print('*');
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		ThreadDemo1 td=new ThreadDemo1();
		td.start();
	}

}
