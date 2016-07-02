package chap5;
class Human5
{
	String name;
	String sex;
	int age;
	String addr;
	public Human5(){
		name=null;
		age=0;
		sex=null;
		addr=null;
	}
	public Human5(String hName,String hSex){
		name=hName;
		sex=hSex;
		System.out.println("第二个构造函数被调用");
	}
	public Human5(String hName,String hSex,int hAge,String hAddr){
		this(hName,hSex);
		age=hAge;
		addr=hAddr;
		System.out.println("第三个构造函数被调用");
	}
	void work(){
		System.out.println("我在工作");
	}
	void eat(){
		System.out.println("我在吃饭");
	}
}
public class HumanDemo5 {

	public static void main(String[] args) {
		Human5 lisi=new Human5("李四","男",20,"中国上海");
		System.out.println("李四的信息:");
		System.out.println("姓名："+lisi.name+"\n性别："+lisi.sex+"\n年龄："+lisi.age+"\n地址："+lisi.addr);
		
	}

}
