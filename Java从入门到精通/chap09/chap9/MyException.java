package chap9;

@SuppressWarnings("serial")
public class MyException extends Exception{
	MyException(){
	}
	MyException(String msg){
		//���ø���ķ���
		super(msg);
	}
}
