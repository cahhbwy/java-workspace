package chap7_2;

public class Class_In_Method {
	void doit(){
		//方法中定义的类
		class Class_in_method{
			Class_in_method(){
				System.out.println("Constructor of Class_in_method");
			}
		}
		new Class_in_method();
	}
	public static void main(String[] args) {
		Class_In_Method cim=new Class_In_Method();
		cim.doit();
	}

}
