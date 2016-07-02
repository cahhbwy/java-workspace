package chap2_4to2_5;

public class LuoJi {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int a=5;
		int b=3;
		boolean b1=(a>4)&(b<4);
		boolean b2=(a<4)|(b>4);
		boolean b3=!(a>4);
		System.out.println("使用与裸机运算符的结果为"+b1);
		System.out.println("使用或裸机运算符的结果为"+b2);
		System.out.println("使用非裸机运算符的结果为"+b3);
	}

}
