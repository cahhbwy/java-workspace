package chap7_2;
//�����ڲ����ʹ��
public class NoNameInerClass2 {
	Constant getConstant(){
		return new Constant(5);
	}
	public static void main(String[] args) {
		NoNameInerClass2 nnic=new NoNameInerClass2();
		System.out.println(nnic.getConstant().n);
		
		
	}

}
