package chap8_3;

public class HumanDemo {

	public static void main(String[] args) {
		Human lisi=new Human("李四","男",24,new Address("中国","山东省","青岛市","XX街"));
		System.out.println("李四的个人信息：");
		System.out.println(lisi.toString());
	}

}
