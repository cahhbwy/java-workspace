package chap6;
class Animal4{
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
final class Tiger4 extends Animal4{
//final使类或方法变成最终类或最终方法，不能被继承
	String tigerType;
	String from;
	void tigerRun(){
		System.out.println("老虎在奔跑");
	}
	void breath(){
		System.out.println("老虎是用肺呼吸的");
	}
}
class Fish4 extends Animal4{
	String fishType;
	void swim(){
		System.out.println("鱼在游泳");
	}
	void breath(){
		System.out.println("鱼是用鳃呼吸的");
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
