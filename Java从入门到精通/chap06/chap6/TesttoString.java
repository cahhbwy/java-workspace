package chap6;
abstract class Animal8{
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
	public String toString(){
		String returnString;
		returnString="名字："+this.name+"\n"+"种类："+this.type+"\n"
				+"年龄："+this.age+"\n"+"体重："+this.weight;
		return returnString;
	}
}
class Fish8 extends Animal8{
	String fishType;
	void swim(){
		System.out.println("鱼在游泳");
	}
	void breath(){
		System.out.println("鱼是用鳃呼吸的");
	}
}
public class TesttoString {

	public static void main(String[] args) {
		Animal8 animal1=new Fish8();
		animal1.age=12;
		animal1.name="dingding";
		animal1.type="dog";
		animal1.weight=12;
		System.out.println(animal1.toString());
		
	}

}
