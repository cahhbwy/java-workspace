package chap9;

public class SimpleDemo {

	@SuppressWarnings("null")
	public static void main(String[] args) {
		String str=null;
		@SuppressWarnings("unused")
		int strLength=0;
		try{
			strLength=str.length();
			//�����쳣��ʱ���������ǰ���е����飬�ҵ��쳣�������飬Ȼ�������س�����ִ��catch������
			System.out.println("�����쳣���֮��");
		}
		catch(NullPointerException e){
			e.printStackTrace();
		}
		//�е�ʱ����Щ������ִ�У������������ݿ��ʱ����ʹ������������ӽ����ͷţ�����ͻ�ϵͳ��Դ�ľ�
		//finally�������쳣���������Ҫ��䣬���涨���������ִ�С���һ��try-catchֻ����һ��finally����
		finally{
			System.out.println("ִ��finally����");
		}
		//��ʹû���׳��쳣��finallyҲ��ִ��
		System.out.println("�����˳�");
	}
}
