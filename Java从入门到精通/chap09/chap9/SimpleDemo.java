package chap9;

public class SimpleDemo {

	@SuppressWarnings("null")
	public static void main(String[] args) {
		String str=null;
		@SuppressWarnings("unused")
		int strLength=0;
		try{
			strLength=str.length();
			//出现异常的时候会跳出当前运行的语句块，找到异常捕获语句块，然后在跳回程序中执行catch后的语句
			System.out.println("出现异常语句之后");
		}
		catch(NullPointerException e){
			e.printStackTrace();
		}
		//有的时候有些语句必须执行，例如连接数据库的时候在使用完后必须对连接进行释放，否则就会系统资源耗尽
		//finally语句块是异常捕获里的重要语句，它规定的语句块必须执行。在一个try-catch只能有一个finally语句块
		finally{
			System.out.println("执行finally语句块");
		}
		//即使没有抛出异常，finally也会执行
		System.out.println("程序退出");
	}
}
