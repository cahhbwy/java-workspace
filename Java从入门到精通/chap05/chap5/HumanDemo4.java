package chap5;
class Human4
{
	String name;
	String sex;
	int age;
	String addr;
	public Human4(){
		name=null;
		age=0;
		sex=null;
		addr=null;
	}
	public Human4(String hName,String hSex){
		name=hName;
		sex=hSex;
	}
	public Human4(String hName,String hSex,int hAge,String hAddr){
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
public class HumanDemo4 {

	public static void main(String[] args) {
		Human4 zhangsan=new Human4();
		Human4 qq=new Human4("青青","女");
		Human4 lisi=new Human4("李四","男",20,"中国上海");
		System.out.println("张三的信息：");
		System.out.println("姓名："+zhangsan.name+"\n性别："+zhangsan.sex+"\n年龄："+zhangsan.age+"\n地址："+zhangsan.addr);
		System.out.println("青青的信息：");
		System.out.println("姓名："+qq.name+"\n性别："+qq.sex+"\n年龄："+qq.age+"\n地址："+qq.addr);
		System.out.println("李四的信息：");
		System.out.println("姓名："+lisi.name+"\n性别："+lisi.sex+"\n年龄："+lisi.age+"\n地址："+lisi.addr);
		
	}

}
