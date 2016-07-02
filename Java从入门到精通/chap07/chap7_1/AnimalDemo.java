package chap7_1;

public class AnimalDemo {

	public static void main(String[] args) {
		Animal fish=new Fish3("大鲨鱼");
		Animal tiger1=new Tiger3("东北虎");
		Mammal tiger2=new Tiger3("华南虎");
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
