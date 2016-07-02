package chap7_2;
//匿名内部类的使用
public class NoNameInerClass2 {
	Constant getConstant(){
		return new Constant(5);
	}
	public static void main(String[] args) {
		NoNameInerClass2 nnic=new NoNameInerClass2();
		System.out.println(nnic.getConstant().n);
		
		
	}

}
