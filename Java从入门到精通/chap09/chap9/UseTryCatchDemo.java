package chap9;

public class UseTryCatchDemo {

	@SuppressWarnings("null")
	public static void main(String[] args) {
		String str=null;
		int strLength=0;
		try{
			strLength=str.length();
		}
		catch(NullPointerException e){
			System.out.println("�����ַ������ȵ�ʱ������쳣");
		}
		System.out.println("strLength�ĳ���:"+strLength);
		
	}

}
