package chap5;
class Human5
{
	String name;
	String sex;
	int age;
	String addr;
	public Human5(){
		name=null;
		age=0;
		sex=null;
		addr=null;
	}
	public Human5(String hName,String hSex){
		name=hName;
		sex=hSex;
		System.out.println("�ڶ������캯��������");
	}
	public Human5(String hName,String hSex,int hAge,String hAddr){
		this(hName,hSex);
		age=hAge;
		addr=hAddr;
		System.out.println("���������캯��������");
	}
	void work(){
		System.out.println("���ڹ���");
	}
	void eat(){
		System.out.println("���ڳԷ�");
	}
}
public class HumanDemo5 {

	public static void main(String[] args) {
		Human5 lisi=new Human5("����","��",20,"�й��Ϻ�");
		System.out.println("���ĵ���Ϣ:");
		System.out.println("������"+lisi.name+"\n�Ա�"+lisi.sex+"\n���䣺"+lisi.age+"\n��ַ��"+lisi.addr);
		
	}

}
