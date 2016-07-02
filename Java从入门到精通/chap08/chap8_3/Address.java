package chap8_3;

public class Address {
	private String country;
	private String province;
	private String city;
	private String street;
	Address(String country,String province,String city,String street){
		this.country=country;
		this.province=province;
		this.city=city;
		this.street=street;
	}
	//本类的toString信息，返回对象的信息
	public String toString(){
		return country+":"+province+":"+city+":"+street;
	}
}
