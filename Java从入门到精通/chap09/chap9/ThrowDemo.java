package chap9;

public class ThrowDemo {
	static void connect() throws ClassNotFoundException{
		try{
			Class.forName("");
		}
		catch(ClassNotFoundException e){
			System.out.println("�����а��쳣�ٴ��׳�");
			throw e;
		}
	}
	public static void main(String[] args) {
		try{
			connect();
		}
		catch(ClassNotFoundException e){
			System.out.println("���������쳣���д���");
		}
	}

}
