package chap6;
class Animal3{
	String type;
	String name;
	int age;
	int weight;
	void eat(){
		System.out.println("���ﰮ�Է�");
	}
	void breath(){
		System.out.println("�������");
	}
}
class Tiger3 extends Animal3{
	String tigerType;
	String from;
	void breath(){
		super.breath();
		System.out.println("�ϻ����÷κ�����");
	}
}
public class SuperDemo {

	public static void main(String[] args) {
		Tiger3 tiger=new Tiger3();
		tiger.breath();
	}

}
