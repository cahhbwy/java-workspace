package chap6;
class Animal2{
	String type;
	String name;
	int age;
	int weight;
	void eat(){
		System.out.println("动物爱吃饭");
	}
	void breath(){
		System.out.println("动物呼吸");
	}
	void sleep(){
		System.out.println("动物在睡觉");
	}
}
class Tiger2 extends Animal2{
	String tigerType;
	String from;
	void tigerRUN(){
		System.out.println("老虎在奔跑");
	}
	void  breath(){
		System.out.println("老虎是用肺呼吸的");
	}
}
class Fish2 extends Animal2{
	String fishType;
	void swim(){
		System.out.println("鱼仔游泳");
	}
	void breath(){
		System.out.println("鱼是用鳃呼吸的");
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
