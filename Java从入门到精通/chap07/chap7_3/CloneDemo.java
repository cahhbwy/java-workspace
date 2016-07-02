package chap7_3;
class Human implements Cloneable{
	String name;
	String sex;
	int age;
	String addr;
	Human(String name, String sex, int age, String addr) {
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
	//�����¡�ķ���
	public Object clone(){
		Human h=null;
		try {
			h=(Human)super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return h;
	}
}
public class CloneDemo {

	public static void main(String[] args) {
		Human zhangsan=new Human("����","��",23,"����");
		Human lisi=(Human)zhangsan.clone();
		lisi.name="����";
		System.out.println("�����ĵ����ָ�Ϊ����");
		System.out.println("���ĵ�����:"+lisi.name);
		System.out.println("����������:"+zhangsan.name);
	}

}
