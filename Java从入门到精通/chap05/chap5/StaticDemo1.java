package chap5;

public class StaticDemo1 {
	int commanint = 0;
	static int staticint = 0;
	StaticDemo1(int x)
	{
		commanint = x;
	}
	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		StaticDemo1 s1 = new StaticDemo1(1);
		StaticDemo1 s2 = new StaticDemo1(2);
		//���������ǶԱȾ�̬��������ͨ������ʹ��
		System.out.println("s1.commanint="+s1.commanint );
		System.out.println("s2.commanint="+s2.commanint );
		System.out.println("s1.staticint="+s1.staticint );
		System.out.println("s2.staticint="+s2.staticint );
		s1.commanint ++;
		System.out.println("�ı�commanint ��ֵ");
		System.out.println("s1.commanint="+s1.commanint );
		System.out.println("s2.commanint="+s2.commanint );
		System.out.println("s1.staticint="+s1.staticint );
		System.out.println("s2.staticint="+s2.staticint );
		s1.staticint++;
		System.out.println("ͨ��s1�ı�staticint ��ֵΪ��"+s1.staticint );
		System.out.println("s2��staticint��ֵΪ��"+s2.staticint );
		
		
	}

}
