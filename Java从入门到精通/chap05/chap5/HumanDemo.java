package chap5;

public class HumanDemo {
	
	public static void main(String[] args) {
		Human wangming;
		wangming=new Human();
		wangming.name ="����";
		wangming.age =25;
		wangming.sex ="��";
		wangming.addr="�й�����";
		System.out.println("������"+wangming.name);
		System.out.println("�Ա�"+wangming.sex);
		System.out.println("���䣺"+wangming.age);
		System.out.println("��ַ��"+wangming.addr);
		System.out.println("�ڸ�ʲô��");
		wangming.eat();
	}

}
