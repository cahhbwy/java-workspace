package chap10_1;

public class ThreadDemo1 extends Thread{
	//���� ThreadDemo1 �Ĺ��췽��
	ThreadDemo1(){}
	//���� ThreadDemo1 �������Ĺ��췽��
	ThreadDemo1(String szName){
		super(szName);
	}
	//���� run ����
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
