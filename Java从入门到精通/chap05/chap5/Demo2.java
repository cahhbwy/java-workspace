package chap5;

public class Demo2 {
	public static final int X=123;
	static int x=10;
	static
	{
		x=0;
	}
	
	Demo2()
	{
		System.out.println(x);
	}
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		Demo2 d=new Demo2();
		System.out.println(X);
	}

}
