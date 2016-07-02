package chap4;

public class ArgaDemo {

	public static void main(String[] args) {
		System.out.println("共接收到"+args.length+"个参数");
		for(int i=0;i<args.length ;i++)
			System.out.println("第"+i+"个参数"+args[i]);
		
	}

}
