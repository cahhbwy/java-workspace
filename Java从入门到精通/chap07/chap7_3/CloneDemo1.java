package chap7_3;
class Human1{
	String name;
	String sex;
	int age;
	String addr;
	Human1(String name, String sex, int age, String addr) {
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.addr = addr;
	}
	void work(){
		System.out.println("���ڹ���");
	}
	void eat(){
		System.out.println("���ڳԷ�");
	}
}
public class CloneDemo1 {

	public static void main(String[] args) {
		Human1 zhangsan=new Human1("����","��",23,"����");
		System.out.println("���������֣�"+zhangsan.name);
		//����ĸ�ֵ
		Human1 lisi=zhangsan;
		lisi.name="����";
		//��ӡ������֮��Ľ��
		System.out.println("�����ĵ����ָ�Ϊ����");
		System.out.println("���ĵ�����:"+lisi.name);
		System.out.println("����������:"+zhangsan.name);
	}

}
