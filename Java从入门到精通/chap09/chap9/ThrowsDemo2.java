package chap9;

public class ThrowsDemo2 {
	static void amethod() throws IllegalAccessException{
		System.out.println("�������׳��쳣");
		throw new IllegalAccessException();
	}
	public static void main(String[] args) {
		try{
			amethod();
		}
		catch(IllegalAccessException e){
			System.out.println("�����쳣");
		}
	}

}
