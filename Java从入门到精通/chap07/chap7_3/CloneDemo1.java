package chap7_3;
class Human1{
	String name;
	String sex;
	int age;
	String addr;
	Human1(String name, String sex, int age, String addr) {
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.addr = addr;
	}
	void work(){
		System.out.println("我在工作");
	}
	void eat(){
		System.out.println("我在吃饭");
	}
}
public class CloneDemo1 {

	public static void main(String[] args) {
		Human1 zhangsan=new Human1("张三","男",23,"北京");
		System.out.println("张三的名字："+zhangsan.name);
		//对象的赋值
		Human1 lisi=zhangsan;
		lisi.name="李四";
		//打印出更改之后的结果
		System.out.println("把李四的名字改为李四");
		System.out.println("李四的名字:"+lisi.name);
		System.out.println("张三的名字:"+zhangsan.name);
	}

}
