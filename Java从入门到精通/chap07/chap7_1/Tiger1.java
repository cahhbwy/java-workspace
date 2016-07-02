package chap7_1;

public class Tiger1 implements Animal{
	public void breath(){
		System.out.println("The tiger breath");
	}
	public void eat(){
		System.out.println("The tiger eat");
	}
	public void sleep(){
		System.out.println("The tiger sleep");
	}
	public static void main(String[] args){
		Tiger1 tiger =new Tiger1();
		tiger.breath();
		tiger.eat();
		tiger.sleep();
	}
}