package chap6;
abstract class Animal8{
	String type;
	String name;
	int age;
	int weight;
	void eat(){
		System.out.println("���ﰮ�Է�");
	}
	abstract void breath();
	void sleep(){
		System.out.println("������˯��");
	}
	public String toString(){
		String returnString;
		returnString="���֣�"+this.name+"\n"+"���ࣺ"+this.type+"\n"
				+"���䣺"+this.age+"\n"+"���أ�"+this.weight;
		return returnString;
	}
}
class Fish8 extends Animal8{
	String fishType;
	void swim(){
		System.out.println("������Ӿ");
	}
	void breath(){
		System.out.println("��������������");
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
