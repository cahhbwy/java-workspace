package chap7_3;
class Human implements Cloneable{
	String name;
	String sex;
	int age;
	String addr;
	Human(String name, String sex, int age, String addr) {
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
	//对象克隆的方法
	public Object clone(){
		Human h=null;
		try {
			h=(Human)super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return h;
	}
}
public class CloneDemo {

	public static void main(String[] args) {
		Human zhangsan=new Human("张三","男",23,"北京");
		Human lisi=(Human)zhangsan.clone();
		lisi.name="李四";
		System.out.println("把李四的名字改为李四");
		System.out.println("李四的名字:"+lisi.name);
		System.out.println("张三的名字:"+zhangsan.name);
	}

}
