package chap9;

@SuppressWarnings("serial")
public class MyException extends Exception{
	MyException(){
	}
	MyException(String msg){
		//调用父类的方法
		super(msg);
	}
}
