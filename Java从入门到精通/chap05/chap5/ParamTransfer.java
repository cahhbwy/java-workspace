package chap5;

public class ParamTransfer {
	public int money;
	void amethod(int i){
		System.out.println("�����õ���i��ֵΪ��"+i);
		i=i*5;
		System.out.println("����ִ����� i=i*5 ���ֵΪ��"+i);
		System.out.println("money ��ֵΪ��"+this.money);
		
	}
	public static void main(String[] args) {
		ParamTransfer pt=new ParamTransfer();
		pt.money=100;
		pt.amethod(pt.money);
	}

}
