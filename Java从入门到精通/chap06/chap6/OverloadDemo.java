package chap6;
class Animal2{
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
	void sleep(){
		System.out.println("������˯��");
	}
}
class Tiger2 extends Animal2{
	String tigerType;
	String from;
	void tigerRUN(){
		System.out.println("�ϻ��ڱ���");
	}
	void  breath(){
		System.out.println("�ϻ����÷κ�����");
	}
}
class Fish2 extends Animal2{
	String fishType;
	void swim(){
		System.out.println("������Ӿ");
	}
	void breath(){
		System.out.println("��������������");
	}
	
}
class Dog2 extends Animal2{
	
}
public class OverloadDemo {

	public static void main(String[] args) {
		Tiger2 tiger=new Tiger2();
		Fish2 fish=new Fish2();
		Dog2 dog=new Dog2();
		tiger.breath();
		fish.breath();
		dog.breath();
	}

}
