package chap6;
abstract class Animal7{
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
	public boolean equals(Object ob){
		boolean bool=false;
		if(this==ob)
			bool=true;
		if(ob==null)
			bool=false;
		if(ob instanceof Animal7){
			bool=((Animal7)ob).age==this.age
					&&((Animal7)ob).name==this.name
					&&((Animal7)ob).type==this.type
					&&((Animal7)ob).weight==this.weight;
		}
		return bool;
	}
}
class Tiger7 extends Animal7{
	String tigerType;
	String from;
	void tigerRun(){
		System.out.println("老虎在奔跑");
	}
	void breath(){
		System.out.println("老虎是用肺呼吸的");
	}
}
class Fish7 extends Animal7{
	String fishType;
	void swim(){
		System.out.println("鱼在游泳");
	}
	void breath(){
		System.out.println("鱼是用鳃呼吸的");
	}
}


public class Testequals {
	
	public static void main(String[] args) {
		Animal7 animal1=new Fish7();
		Animal7 animal2=new Tiger7();
		Animal7 animal3=new Fish7();
		animal1.age=12;
		animal1.name="dingding";
		animal1.weight=12;
		animal1.type="dog";
		animal2.age=12;
		animal2.name="dingding";
		animal2.type="dog";
		animal2.weight=12;
		animal3.age=12;
		animal3.name="dongdong";
		animal3.type="dog";
		animal3.weight=12;
		System.out.println(animal1.equals(animal2));
		System.out.println(animal1.equals(animal3));
		
	}

}
