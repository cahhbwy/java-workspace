package chap5;
class Human2{
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
public class HumanDemo2 {
	
	public static void main(String[] args) {
		Human2 zhangsan=new Human2();
		Human2 lisi=new Human2();
		zhangsan.name="����";
		zhangsan.sex ="��";
		zhangsan.age=25;
		zhangsan.addr="�й�����";
		lisi=zhangsan;
		System.out.print("����������:");
		System.out.println(zhangsan.name );
		System.out.print("���ĵ����֣�");
		System.out.println(lisi.name );
		System.out.println("�ı����ĵ�����");
		lisi.name ="����";
		System.out.print("�������ĵ�����Ϊ��");
		System.out.println(lisi.name );
		System.out.print("��������������Ϊ��");
		System.out.println(zhangsan.name );
	}

}
