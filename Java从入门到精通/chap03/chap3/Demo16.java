package chap3;

public class Demo16 {

	public static void main(String[] args) {
		for(int i=0;i<10;i++)
			if(i<5)
				System.out.println("第"+i+"次循环");
			else if(i==5)
				return;
			else
				System.out.println("第"+i+"次循环");
	}

}
