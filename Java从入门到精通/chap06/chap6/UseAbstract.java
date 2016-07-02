package chap6;
abstract class Animal5{
	String type;
	String name;
	int age;
	int weight;
	void eat(){
		System.out.println("动物爱吃饭");
	}
	abstract void breath();
	void sleep(){
		System.out.println("动物在睡觉");
	}
}
class Tiger5 extends Animal5{
	String tigerType;
	String from;
	void tigerRun(){
		System.out.println("老虎在奔跑");
	}
	void breath(){
		System.out.println("老虎是用肺呼吸的");
	}
}
class Fish5 extends Animal5{
	String fishType;
	void swim(){
		System.out.println("鱼在游泳");
	}
	void breath(){
		System.out.println("鱼是用鳃呼吸的");
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
