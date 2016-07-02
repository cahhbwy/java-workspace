package chap9;

public class CatchDemo {

	public static void main(String[] args) {
		try{
			@SuppressWarnings("unused")
			int a=15/0;
		}
		catch(ArithmeticException e){
			System.out.println("捕获ArithmeticException异常");
		}
		catch(Exception e){
			System.out.println("捕获Exception异常");
		}
		//Exception是ArithmeticException的父类，所以应该把子类的放在前面，否则父类会捕获所有它的子类的异常，而使子类异常catch语句永远不会执行
	}

}
