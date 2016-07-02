package chap9;

public class ThrowsDemo1 {
	static int amethod(int a,int b){//throws ArithmeticException
		if(b==0)
			throw new ArithmeticException();
		else return a/b;
	}
	public static void main(String[] args) {
		System.out.println(amethod(15,5));
		System.out.println(amethod(15,0));
	}

}
