package chap5;
class Humanx{
	String name;
	String sex;
	int age;
	String addr;
	void work(){
		System.out.println("���ڹ���");
	}
	void eat(){
		System.out.println("���ڳԷ�");
	}
}
public class ConstructorDemo1 {

	public static void main(String[] args) {
		Humanx zhangsan=new Humanx();
		System.out.println("����Ĭ��ֵ"+zhangsan.name);
		System.out.println("�Ա�Ĭ��ֵ"+zhangsan.sex);
		System.out.println("����Ĭ��ֵ"+zhangsan.age);
		System.out.println("��ַĬ��ֵ"+zhangsan.addr);
		
	}

}
