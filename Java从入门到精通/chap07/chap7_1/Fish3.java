package chap7_1;

public class Fish3 implements Animal{
	String name;
	public Fish3(String nm) {
		name = nm;
	}
	public void breath(){
		System.out.println(name +"��������");
	}
	public void sleep() {
		System.out.println(name +"�������۾�˯��");
	}
	public void eat() {
		System.out.println(name +"�ڳ�ˮ��");
	}
}