package chap8_1;
//��FatherClass�ڰ�chap8_1_1_2another
import chap8_1_1_2another.FatherClass2;


class SonClass2 extends FatherClass2{
	void print(){
		SonClass2 son=new SonClass2();
		System.out.println("������ķ����У�");
		System.out.println(son.str1);
		System.out.println(son.str2);
	}
}
public class Demo2 {

	public static void main(String[] args) {
		SonClass2 son2=new SonClass2();
		son2.print();
	}

}
