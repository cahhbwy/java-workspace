package chap5;

public class StaticDemo1 {
	int commanint = 0;
	static int staticint = 0;
	StaticDemo1(int x)
	{
		commanint = x;
	}
	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		StaticDemo1 s1 = new StaticDemo1(1);
		StaticDemo1 s2 = new StaticDemo1(2);
		//下面的语句是对比静态变量和普通变量的使用
		System.out.println("s1.commanint="+s1.commanint );
		System.out.println("s2.commanint="+s2.commanint );
		System.out.println("s1.staticint="+s1.staticint );
		System.out.println("s2.staticint="+s2.staticint );
		s1.commanint ++;
		System.out.println("改变commanint 的值");
		System.out.println("s1.commanint="+s1.commanint );
		System.out.println("s2.commanint="+s2.commanint );
		System.out.println("s1.staticint="+s1.staticint );
		System.out.println("s2.staticint="+s2.staticint );
		s1.staticint++;
		System.out.println("通过s1改变staticint 的值为："+s1.staticint );
		System.out.println("s2的staticint的值为："+s2.staticint );
		
		
	}

}
