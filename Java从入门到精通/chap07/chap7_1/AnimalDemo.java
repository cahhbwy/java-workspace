package chap7_1;

public class AnimalDemo {

	public static void main(String[] args) {
		Animal fish=new Fish3("������");
		Animal tiger1=new Tiger3("������");
		Mammal tiger2=new Tiger3("���ϻ�");
		fish.breath();
		fish.eat();
		fish.sleep();
		tiger1.breath();
		tiger1.eat();
		tiger1.sleep();
		((Tiger3)tiger1).run();
		tiger2.breath();
		tiger2.eat();
		tiger2.sleep();
		tiger2.run();
		
	}

}
