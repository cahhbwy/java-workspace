package chap5;

public class StaticMethod {
	
	public static void main(String[] args) {
		System.out.println("用静态方法打印出信息");
		MyMethod.printString("str类型");
		MyMethod.printInt(5);
	}

}
class MyMethod
{
	static void printString(String str)
	{
		System.out.println(str);
	}
	static void printInt(int i)
	{
		System.out.println(i);
	}
}