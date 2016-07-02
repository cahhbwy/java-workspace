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
		Addr addr=new Addr("中国","北京","朝阳区");
		Human2 zhangsan=new Human2("张三",24,addr);
		Human2 lisi=(Human2)zhangsan.clone();
		System.out.println("张三的地址：");
		System.out.println(zhangsan.addr.country+zhangsan.addr.province+zhangsan.addr.city);
		System.out.println("李四的地址:");
		System.out.println(lisi.addr.country+lisi.addr.province+lisi.addr.city);
		lisi.addr.country="中国";
		lisi.addr.province="山东";
		lisi.addr.city="青岛";
		System.out.println("修改李四的地址为：中国山东青岛");
		System.out.println("张三的地址：");
		System.out.println(zhangsan.addr.country+zhangsan.addr.province+zhangsan.addr.city);
		System.out.println("李四的地址:");
		System.out.println(lisi.addr.country+lisi.addr.province+lisi.addr.city);
		
		
	}

}
