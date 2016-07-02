package chap5;

public class HumanDemo {
	
	public static void main(String[] args) {
		Human wangming;
		wangming=new Human();
		wangming.name ="王明";
		wangming.age =25;
		wangming.sex ="男";
		wangming.addr="中国北京";
		System.out.println("姓名："+wangming.name);
		System.out.println("性别："+wangming.sex);
		System.out.println("年龄："+wangming.age);
		System.out.println("地址："+wangming.addr);
		System.out.println("在干什么？");
		wangming.eat();
	}

}
