package chap7_1;

public class Tiger3 implements Mammal{
	String name;
	public Tiger3(String nm) {
		name = nm;
	}
	public void breath(){
		System.out.println(name +"The tiger breath");
	}
	public void sleep() {
		System.out.println(name +"The tiger sleep");
	}
	public void eat() {
		System.out.println(name +"The tiger eat");
	}
	public void run() {
		System.out.println(name +"The tiger run");
	}
}
