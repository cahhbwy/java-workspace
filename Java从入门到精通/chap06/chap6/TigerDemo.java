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
		tiger.tigerType="东北虎";
		tiger.from="长白山";
		System.out.println("Animal 属性：种类="+tiger.type);
		System.out.println("Animal 属性：名字="+tiger.name);
		System.out.println("Animal 属性：年龄="+tiger.age);
		System.out.println("Animal 属性：体重="+tiger.weight);
		System.out.println("Tiger 属性：老虎种类="+tiger.tigerType);
		System.out.println("Tiger 属性：产地="+tiger.from);
		System.out.println("Animal 方法：呼吸");
		tiger.breath();
		System.out.println("Animal 方法：吃饭");
		tiger.eat();
		System.out.println("Animal 方法：睡觉");
		tiger.sleep();
		System.out.println("Tiger 方法：奔跑");
		tiger.tigerRUN();
		
		
	}

}
