package chap6;
class A{
	A(){
		System.out.println("���� A�Ĺ��캯��");
	}
}
class B extends A{
	B(){
		System.out.println("���� B�Ĺ��캯��");
	}
}
class C extends B{
	C(){
		System.out.println("���� C�Ĺ��캯��");
	}
}
public class CallConstructor {

	public static void main(String[] args) {
		@SuppressWarnings("unused")
		C c=new C();
	}

}
