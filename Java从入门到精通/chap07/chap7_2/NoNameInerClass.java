package chap7_2;
class Constant{
	int n;
	Constant(int i){
		n=i;
	}
}
//��ConstantDemo
class ConstantDemo{
	//�÷������һ��Constant����
	Constant getConstant(){
		return new Constant(9);
	}
}
public class NoNameInerClass {

	public static void main(String[] args) {
		ConstantDemo cd=new ConstantDemo();
		System.out.println(cd.getConstant().n);
	}

}
