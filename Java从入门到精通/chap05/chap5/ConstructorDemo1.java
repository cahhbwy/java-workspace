package chap5;
class Humanx{
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
public class ConstructorDemo1 {

	public static void main(String[] args) {
		Humanx zhangsan=new Humanx();
		System.out.println("姓名默认值"+zhangsan.name);
		System.out.println("性别默认值"+zhangsan.sex);
		System.out.println("年龄默认值"+zhangsan.age);
		System.out.println("地址默认值"+zhangsan.addr);
		
	}

}
