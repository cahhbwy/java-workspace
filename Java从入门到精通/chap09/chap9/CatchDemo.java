package chap9;

public class CatchDemo {

	public static void main(String[] args) {
		try{
			@SuppressWarnings("unused")
			int a=15/0;
		}
		catch(ArithmeticException e){
			System.out.println("����ArithmeticException�쳣");
		}
		catch(Exception e){
			System.out.println("����Exception�쳣");
		}
		//Exception��ArithmeticException�ĸ��࣬����Ӧ�ð�����ķ���ǰ�棬������Ჶ����������������쳣����ʹ�����쳣catch�����Զ����ִ��
	}

}
