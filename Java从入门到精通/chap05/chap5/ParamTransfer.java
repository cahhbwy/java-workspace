package chap5;

public class ParamTransfer {
	public int money;
	void amethod(int i){
		System.out.println("方法得到的i的值为："+i);
		i=i*5;
		System.out.println("方法执行语句 i=i*5 后的值为："+i);
		System.out.println("money 的值为："+this.money);
		
	}
	public static void main(String[] args) {
		ParamTransfer pt=new ParamTransfer();
		pt.money=100;
		pt.amethod(pt.money);
	}

}
