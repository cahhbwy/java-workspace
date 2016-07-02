package chap7_1;

public class Tiger2 implements Mammal{
	public void breath(){
		System.out.println("The tiger breath");
	}
	public void eat(){
		System.out.println("The tiger run");
	}
	public void sleep(){
		System.out.println("The tiger sleep");
	}
	public void run(){
		System.out.println("The tiger run");
	}
	public static void main(String[] args) {
		Tiger2 tiger=new Tiger2();
		tiger.breath();
		tiger.eat();
		tiger.sleep();
		tiger.run();
	}

}
