package chap10_1;
//���������µ��߳�
public class ThreadDemo2 extends Thread{
	//�����޲������չ��췽��
	ThreadDemo2(){}
	//���������ַ��������Ĺ��췽��
	ThreadDemo2(String szName){
		super(szName);
	}
	//����run����
	public void run(){
		for(int count=1,row=1;row<10;row++,count++){
			for(int i=0;i<count;i++){
				System.out.print('*');
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		ThreadDemo2 td1=new ThreadDemo2();
		ThreadDemo2 td2=new ThreadDemo2();
		ThreadDemo2 td3=new ThreadDemo2();
		td1.start();
		td2.start();
		td3.start();
	}

}
