package chap5;

public class OverloadDemo {
	void method(){
		System.out.println("无参数方法被调用");
		}
	void method(int a){
		System.out.println("参数为int类型方法被调用");
	}
	void method(double d){
		System.out.println("参数为double类型方法被调用");
	}
	void method(String s){
		System.out.println("参数为String类型方法被调用");
	}
	public static void main(String[] args) {
		OverloadDemo ov=new OverloadDemo();
		ov.method();
		ov.method(4);
		ov.method(4.5D);
		ov.method("a String");
		
	}

}
