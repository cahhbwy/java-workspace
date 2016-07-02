package chap6;
abstract class Animal5{
	String type;
	String name;
	int age;
	int weight;
	void eat(){
		System.out.println("���ﰮ�Է�");
	}
	abstract void breath();
	void sleep(){
		System.out.println("������˯��");
	}
}
class Tiger5 extends Animal5{
	String tigerType;
	String from;
	void tigerRun(){
		System.out.println("�ϻ��ڱ���");
	}
	void breath(){
		System.out.println("�ϻ����÷κ�����");
	}
}
class Fish5 extends Animal5{
	String fishType;
	void swim(){
		System.out.println("������Ӿ");
	}
	void breath(){
		System.out.println("��������������");
	}
}
public class UseAbstract {

	public static void main(String[] args) {
		Animal5 animal1=new Fish5();
		animal1.breath();
		Animal5 animal2=new Tiger5();
		animal2.breath();
		
		((Fish5)animal1).swim();
		((Tiger5)animal2).tigerRun();
		
	}

}
