package chap5;

public class OverloadDemo {
	void method(){
		System.out.println("�޲�������������");
		}
	void method(int a){
		System.out.println("����Ϊint���ͷ���������");
	}
	void method(double d){
		System.out.println("����Ϊdouble���ͷ���������");
	}
	void method(String s){
		System.out.println("����ΪString���ͷ���������");
	}
	public static void main(String[] args) {
		OverloadDemo ov=new OverloadDemo();
		ov.method();
		ov.method(4);
		ov.method(4.5D);
		ov.method("a String");
		
	}

}
