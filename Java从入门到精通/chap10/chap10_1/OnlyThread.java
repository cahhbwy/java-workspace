package chap10_1;

public class OnlyThread {

	public static void main(String[] args) {
		run();
	}
	public static void run(){
		for(int count=1,row=1;row<10;row++,count++){
			for(int i=0;i<count;i++){
				System.out.print('*');
			}
			System.out.println();
		}
	}
}
