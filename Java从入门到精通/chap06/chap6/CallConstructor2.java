package chap6;

class A2{
	A2(){
		System.out.println("���� A2�Ĺ��캯��");
	}
	A2(int i){
		System.out.println("���� A2���вι��캯��"+i);
	}
}
class B2 extends A2{
	B2(){
		System.out.println("���� B2�Ĺ��캯��");
	}
	B2(int i){
		super(4);
		System.out.println("���� A2���вι��캯��"+i);
	}
}
class C2 extends B2{
	C2(){
		System.out.println("���� C2�Ĺ��캯��");
	}
	C2(int i){
		super(5);
		System.out.println("���� C2���вι��캯��"+i);
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
