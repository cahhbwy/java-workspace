package chap8_1;
class Human
{
	//��Ա���Զ���˽�еģ��κ����඼�ǲ��ܼ̳е�
	private String name;
	private String sex;
	private int age;
	private String addr;
	//public�����úͷ��ʷ���
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public void work(){
		System.out.println("���ڹ���");
	}
	public void eat(){
		System.out.println("���ڳԷ�");
	}
}
public class HumanDemo {

	public static void main(String[] args) {
		Human zhangsan=new Human();
		zhangsan.setName("����");
		zhangsan.setAge(25);
		zhangsan.setSex("��");
		zhangsan.setAddr("�й�����");
		System.out.println("�����ĸ�����Ϣ���£�");
		System.out.println("������"+zhangsan.getName());
		System.out.println("�Ա�"+zhangsan.getSex());
		System.out.println("���䣺"+zhangsan.getAge());
		System.out.println("��ַ��"+zhangsan.getAddr());
		
	}

}
