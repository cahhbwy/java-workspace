package chap5;

public class OverloadDemo2 {
	void method(){
		System.out.println("�޲�������������");
		}
	void method(double d){
		System.out.println("����Ϊdouble���ͷ���������");
	}
	void method(String s){
		System.out.println("����ΪString���ͷ���������");
	}
	public static void main(String[] args) {
		OverloadDemo2 ov=new OverloadDemo2();
		ov.method();
		ov.method(4);
		ov.method(4.5D);
		ov.method("a String");
	}

}
