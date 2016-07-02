package chap7_1;

public class Fish3 implements Animal{
	String name;
	public Fish3(String nm) {
		name = nm;
	}
	public void breath(){
		System.out.println(name +"ÓÃÈùºôÎü");
	}
	public void sleep() {
		System.out.println(name +"ÔÚÕö×ÅÑÛ¾¦Ë¯¾õ");
	}
	public void eat() {
		System.out.println(name +"ÔÚ³ÔË®²İ");
	}
}