package chap6;
class Animal{
	String type;
	String name;
	int age;
	int weight;
	void eat(){
		System.out.println("animal eat");
	}
	void breath(){
		System.out.println("animal breath");
	}
	void sleep(){
		System.out.println("animal sleep");
	}
}
class Tiger extends Animal{
	String tigerType;
	String from;
	void tigerRUN(){
		System.out.println("the tiger run");
	}
}

public class TigerDemo {

	public static void main(String[] args) {
		Tiger tiger=new Tiger();
		tiger.type="Tiger";
		tiger.name="huhu";
		tiger.age=12;
		tiger.weight=120;
		tiger.tigerType="������";
		tiger.from="����ɽ";
		System.out.println("Animal ���ԣ�����="+tiger.type);
		System.out.println("Animal ���ԣ�����="+tiger.name);
		System.out.println("Animal ���ԣ�����="+tiger.age);
		System.out.println("Animal ���ԣ�����="+tiger.weight);
		System.out.println("Tiger ���ԣ��ϻ�����="+tiger.tigerType);
		System.out.println("Tiger ���ԣ�����="+tiger.from);
		System.out.println("Animal ����������");
		tiger.breath();
		System.out.println("Animal �������Է�");
		tiger.eat();
		System.out.println("Animal ������˯��");
		tiger.sleep();
		System.out.println("Tiger ����������");
		tiger.tigerRUN();
		
		
	}

}
