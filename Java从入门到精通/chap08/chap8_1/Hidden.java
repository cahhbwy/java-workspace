package chap8_1;
class Father3{
	String str="�����Str��Ա����";
}
class Son3 extends Father3{
	String str="�����Str��Ա����";
	void show(){
		System.out.println(super.str);
	}
}
public class Hidden {

	public static void main(String[] args){
		Father3 father=new Father3();
		Son3 son=new Son3();
		System.out.println("����������Str");
		System.out.println(father.str);
		System.out.println("����������Str");
		//�������ͬ���ĸ����Ա����ʱ�ǵ��������Լ��ı���
		System.out.println(son.str);
		//�����صĸ����Ա����ͨ��super�ؼ���ʵ�ַ���
		System.out.println("�������صĸ����Ա����");
		son.show();
	}

}
