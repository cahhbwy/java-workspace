package chap7_2;
class Constant{
	int n;
	Constant(int i){
		n=i;
	}
}
//类ConstantDemo
class ConstantDemo{
	//该方法获得一个Constant对象
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
