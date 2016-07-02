package chap6;
class A{
	A(){
		System.out.println("调用 A的构造函数");
	}
}
class B extends A{
	B(){
		System.out.println("调用 B的构造函数");
	}
}
class C extends B{
	C(){
		System.out.println("调用 C的构造函数");
	}
}
public class CallConstructor {

	public static void main(String[] args) {
		@SuppressWarnings("unused")
		C c=new C();
	}

}
