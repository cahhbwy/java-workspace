package chap6;
class Animal4{
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
final class Tiger4 extends Animal4{
//finalʹ��򷽷��������������շ��������ܱ��̳�
	String tigerType;
	String from;
	void tigerRun(){
		System.out.println("�ϻ��ڱ���");
	}
	void breath(){
		System.out.println("�ϻ����÷κ�����");
	}
}
class Fish4 extends Animal4{
	String fishType;
	void swim(){
		System.out.println("������Ӿ");
	}
	void breath(){
		System.out.println("��������������");
	}
}
public class DynamicMethodDemo {
	
	
	public static void main(String[] args) {
		Animal4 []animal=new Animal4[3];
		animal[0]=new Animal4();
		animal[1]=new Tiger4();
		animal[2]=new Fish4();
		animal[0].breath();
		animal[1].breath();
		animal[2].breath();
		
	}

}
