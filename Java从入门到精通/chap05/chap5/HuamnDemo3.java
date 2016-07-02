package chap5;
class Human3{
	String name;
	String sex;
	int age;
	String addr;
	public Human3(String hName,String hSex,int hAge,String hAddr){
		name=hName;
		sex=hSex;
		age=hAge;
		addr=hAddr;
	}
	void work(){
		System.out.println("我在工作");
	}
	void eat(){
		System.out.println("我在吃饭");
	}
}
public class HuamnDemo3 {

	public static void main(String[] args) {
		Human3 zhangsan=new Human3("张三","男",25,"中国北京");
		Human3 lisi=new Human3("李四","男",20,"中国上海");
		System.out.println("张三的信息");
		System.out.println("姓名："+zhangsan.name);
		System.out.println("性别："+zhangsan.sex);
		System.out.println("年龄："+zhangsan.age);
		System.out.println("地址："+zhangsan.addr);
		System.out.println("李四的信息");
		System.out.println("姓名："+lisi.name);
		System.out.println("性别："+lisi.sex);
		System.out.println("年龄："+lisi.age);
		System.out.println("地址："+lisi.addr);
	}

}
