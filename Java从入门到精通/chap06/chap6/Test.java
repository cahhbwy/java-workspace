package chap6;
abstract class Animal6{
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
class Tiger6 extends Animal6{
	String tigerType;
	String from;
	void tigerRun(){
		System.out.println("老虎在奔跑");
	}
	void breath(){
		System.out.println("老虎是用肺呼吸的");
	}
}
class Fish6 extends Animal6{
	String fishType;
	void swim(){
		System.out.println("鱼在游泳");
	}
	void breath(){
		System.out.println("鱼是用鳃呼吸的");
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
