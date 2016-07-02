package chap6;

class A2{
	A2(){
		System.out.println("调用 A2的构造函数");
	}
	A2(int i){
		System.out.println("调用 A2的有参构造函数"+i);
	}
}
class B2 extends A2{
	B2(){
		System.out.println("调用 B2的构造函数");
	}
	B2(int i){
		super(4);
		System.out.println("调用 A2的有参构造函数"+i);
	}
}
class C2 extends B2{
	C2(){
		System.out.println("调用 C2的构造函数");
	}
	C2(int i){
		super(5);
		System.out.println("调用 C2的有参构造函数"+i);
	}
}
public class CallConstructor2 {

	public static void main(String[] args) {
		@SuppressWarnings("unused")
		C2 c=new C2();
		@SuppressWarnings("unused")
		C2 c0=new C2(6);
	}

}
