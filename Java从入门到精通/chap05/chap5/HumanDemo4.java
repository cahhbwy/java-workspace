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
		System.out.println("���ڹ���");
	}
	void eat(){
		System.out.println("���ڳԷ�");
	}
}
public class HumanDemo4 {

	public static void main(String[] args) {
		Human4 zhangsan=new Human4();
		Human4 qq=new Human4("����","Ů");
		Human4 lisi=new Human4("����","��",20,"�й��Ϻ�");
		System.out.println("��������Ϣ��");
		System.out.println("������"+zhangsan.name+"\n�Ա�"+zhangsan.sex+"\n���䣺"+zhangsan.age+"\n��ַ��"+zhangsan.addr);
		System.out.println("�������Ϣ��");
		System.out.println("������"+qq.name+"\n�Ա�"+qq.sex+"\n���䣺"+qq.age+"\n��ַ��"+qq.addr);
		System.out.println("���ĵ���Ϣ��");
		System.out.println("������"+lisi.name+"\n�Ա�"+lisi.sex+"\n���䣺"+lisi.age+"\n��ַ��"+lisi.addr);
		
	}

}
