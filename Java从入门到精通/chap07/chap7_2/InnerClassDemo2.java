package chap7_2;

class Outer2{
	String out_string="String in outer";
	void useIner1(){
		Iner1 in1=new Iner1();
		in1.print();
	}
	void useIner2(){
		Iner2 in2=new Iner2();
		in2.print();
	}
	//非静态内部类
	class Iner1{
		void print(){
			System.out.println("Iner1.print()");
			//可以直接使用宿主类的变量
			System.out.println("Outer.out_string="+out_string+" ");
		}
	}
	//静态内部类
	static class Iner2{
		void print(){
			System.out.println("Iner2.print()");
			//System.out.println("Outer.out_string="+out_string+" ");
			//需要使用对象来方法宿主类的变量
			Outer2 outer=new Outer2();
			System.out.println("Outer.out_string="+outer.out_string);
		}
	}
}

public class InnerClassDemo2 {

	public static void main(String[] args) {
		Outer2 out=new Outer2();
		out.useIner1();
		out.useIner2();
	}

}
