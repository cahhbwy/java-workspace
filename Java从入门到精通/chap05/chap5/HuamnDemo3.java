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
		System.out.println("���ڹ���");
	}
	void eat(){
		System.out.println("���ڳԷ�");
	}
}
public class HuamnDemo3 {

	public static void main(String[] args) {
		Human3 zhangsan=new Human3("����","��",25,"�й�����");
		Human3 lisi=new Human3("����","��",20,"�й��Ϻ�");
		System.out.println("��������Ϣ");
		System.out.println("������"+zhangsan.name);
		System.out.println("�Ա�"+zhangsan.sex);
		System.out.println("���䣺"+zhangsan.age);
		System.out.println("��ַ��"+zhangsan.addr);
		System.out.println("���ĵ���Ϣ");
		System.out.println("������"+lisi.name);
		System.out.println("�Ա�"+lisi.sex);
		System.out.println("���䣺"+lisi.age);
		System.out.println("��ַ��"+lisi.addr);
	}

}
