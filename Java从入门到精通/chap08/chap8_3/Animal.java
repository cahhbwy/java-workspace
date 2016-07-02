package chap8_3;

public class Animal {
	private String type;
	private String name;
	private int age;
	private int weight;
	Animal(){
		type=null;
		name=null;
		age=0;
		weight=0;
	}
	Animal(String type,String name,int age,int weight){
		this.type=type;
		this.name=name;
		this.age=age;
		this.weight=weight;
	}
	public void eat(){
		System.out.println("animal eat");
	}
	public void breath(){
		System.out.println("animal breath");
	}
	public void sleep(){
		System.out.println("animal sleep");
	}
	String getType() {
		return type;
	}
	void setType(String type) {
		this.type = type;
	}
	String getName() {
		return name;
	}
	void setName(String name) {
		this.name = name;
	}
	int getAge() {
		return age;
	}
	void setAge(int age) {
		this.age = age;
	}
	int getWeight() {
		return weight;
	}
	void setWeight(int weight) {
		this.weight = weight;
	}
	
}
