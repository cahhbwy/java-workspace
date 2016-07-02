package chap6;
class Animal3{
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
}
class Tiger3 extends Animal3{
	String tigerType;
	String from;
	void breath(){
		super.breath();
		System.out.println("老虎是用肺呼吸的");
	}
}
public class SuperDemo {

	public static void main(String[] args) {
		Tiger3 tiger=new Tiger3();
		tiger.breath();
	}

}
