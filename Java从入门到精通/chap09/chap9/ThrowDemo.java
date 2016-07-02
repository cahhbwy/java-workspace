package chap9;

public class ThrowDemo {
	static void connect() throws ClassNotFoundException{
		try{
			Class.forName("");
		}
		catch(ClassNotFoundException e){
			System.out.println("方法中把异常再次抛出");
			throw e;
		}
	}
	public static void main(String[] args) {
		try{
			connect();
		}
		catch(ClassNotFoundException e){
			System.out.println("主方法对异常进行处理");
		}
	}

}
