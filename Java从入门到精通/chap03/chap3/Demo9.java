package chap3;

public class Demo9 {

	public static void main(String[] args) {
		boolean b=true;
		System.out.println("ѭ��1");
		for(int i=0;b;i++)
		{
			if(i==5)
				b=false;
			System.out.println("i="+i);
		}
		int i=0;
		b=true;
		System.out.println("ѭ��2");
		for(;b;)
		{
			System.out.println("i="+i);
			if(i==5)
				b=false;
			i++;
		}
		System.out.println("ѭ��3");
//		for(;;)
//		{
			
	//	}
	}

}
