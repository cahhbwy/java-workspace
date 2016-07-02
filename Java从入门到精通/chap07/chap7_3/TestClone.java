package chap7_3;
class Addr implements Cloneable{
	String country;
	String province;
	String city;
	public Addr(String country, String province, String city) {
		this.country = country;
		this.province = province;
		this.city = city;
	}
	public Object clone(){
		Addr addr=null;
		try {
			addr=(Addr)super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return addr;
	}
}

class Human2 implements Cloneable{
	String name;
	int age;
	Addr addr;
	public Human2(String name, int age, Addr addr) {
		this.name = name;
		this.age = age;
		this.addr = addr;
	}
	public Object clone(){
		Human2 h=null;
		try {
			h=(Human2)super.clone();
			h.addr=(Addr)this.addr.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return h;
	}
}
public class TestClone {

	public static void main(String[] args) {
		Addr addr=new Addr("�й�","����","������");
		Human2 zhangsan=new Human2("����",24,addr);
		Human2 lisi=(Human2)zhangsan.clone();
		System.out.println("�����ĵ�ַ��");
		System.out.println(zhangsan.addr.country+zhangsan.addr.province+zhangsan.addr.city);
		System.out.println("���ĵĵ�ַ:");
		System.out.println(lisi.addr.country+lisi.addr.province+lisi.addr.city);
		lisi.addr.country="�й�";
		lisi.addr.province="ɽ��";
		lisi.addr.city="�ൺ";
		System.out.println("�޸����ĵĵ�ַΪ���й�ɽ���ൺ");
		System.out.println("�����ĵ�ַ��");
		System.out.println(zhangsan.addr.country+zhangsan.addr.province+zhangsan.addr.city);
		System.out.println("���ĵĵ�ַ:");
		System.out.println(lisi.addr.country+lisi.addr.province+lisi.addr.city);
		
		
	}

}
