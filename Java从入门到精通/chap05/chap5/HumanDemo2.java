package chap5;
class Human2{
	String name;
	String sex;
	int age;
	String addr;
	void work(){
		System.out.println("我在工作");
	}
	void eat(){
		System.out.println("我在吃饭");
	}
}
public class HumanDemo2 {
	
	public static void main(String[] args) {
		Human2 zhangsan=new Human2();
		Human2 lisi=new Human2();
		zhangsan.name="张三";
		zhangsan.sex ="男";
		zhangsan.age=25;
		zhangsan.addr="中国北京";
		lisi=zhangsan;
		System.out.print("张三的名字:");
		System.out.println(zhangsan.name );
		System.out.print("李四的名字：");
		System.out.println(lisi.name );
		System.out.println("改变李四的名字");
		lisi.name ="李四";
		System.out.print("现在李四的名字为：");
		System.out.println(lisi.name );
		System.out.print("现在张三的名字为：");
		System.out.println(zhangsan.name );
	}

}
