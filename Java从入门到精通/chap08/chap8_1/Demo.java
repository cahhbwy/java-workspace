package chap8_1;
class FatherClass{
	//public的成员变量，它的任何之类都可以继承它
	public String str1="父类的public 属性";
	protected String str2="父类的protected属性";
	//对于默认修饰符，包外的子类是不能访问它的，包内类可以继承
	String str3="父类默认修饰符的属性";
}
class SonClass extends FatherClass{
	void print(){
		SonClass son=new SonClass();
		System.out.println("在子类的方法中：");
		System.out.println(son.str1);
		System.out.println(son.str2);
		System.out.println(son.str3);
	}
}
public class Demo {

	public static void main(String[] args) {
		SonClass son=new SonClass();
		son.print();
	}

}




