package chap6;
abstract class Animal6{
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
class Tiger6 extends Animal6{
	String tigerType;
	String from;
	void tigerRun(){
		System.out.println("�ϻ��ڱ���");
	}
	void breath(){
		System.out.println("�ϻ����÷κ�����");
	}
}
class Fish6 extends Animal6{
	String fishType;
	void swim(){
		System.out.println("������Ӿ");
	}
	void breath(){
		System.out.println("��������������");
	}
}
public class Test {

	public static void main(String[] args) {
		Object[] object=new Object[3];
		Animal6 animal1=new Fish6();
		Animal6 animal2=new Tiger6();
		object[0]=animal1;
		object[1]=animal2;
		object[2]=new String("String");
		((Fish6)object[0]).swim();
	}

}
