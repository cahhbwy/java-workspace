package chap9;

public class TestMyException {

	public static void main(String[] args) {
		MyException mec=new MyException("�������Զ�����쳣��");
		System.out.println(mec.getMessage());
		System.out.println(mec.toString());
	}

}
