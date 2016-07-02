package chap8_1;
class Father3{
	String str="父类的Str成员变量";
}
class Son3 extends Father3{
	String str="子类的Str成员变量";
	void show(){
		System.out.println(super.str);
	}
}
public class Hidden {

	public static void main(String[] args){
		Father3 father=new Father3();
		Son3 son=new Son3();
		System.out.println("父类对象访问Str");
		System.out.println(father.str);
		System.out.println("子类对象访问Str");
		//子类访问同名的父类成员变量时是调用子类自己的变量
		System.out.println(son.str);
		//被隐藏的父类成员变量通过super关键字实现访问
		System.out.println("调用隐藏的父类成员变量");
		son.show();
	}

}
