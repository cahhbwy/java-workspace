package chap8_1;
class FatherClass{
	//public�ĳ�Ա�����������κ�֮�඼���Լ̳���
	public String str1="�����public ����";
	protected String str2="�����protected����";
	//����Ĭ�����η�������������ǲ��ܷ������ģ���������Լ̳�
	String str3="����Ĭ�����η�������";
}
class SonClass extends FatherClass{
	void print(){
		SonClass son=new SonClass();
		System.out.println("������ķ����У�");
		System.out.println(son.str1);
		System.out.println(son.str2);
		System.out.println(son.str3);
	}
}
public class Demo {

	public static void main(String[] args) {
		SonClass son=new SonClass();
		son.print();
	}

}




