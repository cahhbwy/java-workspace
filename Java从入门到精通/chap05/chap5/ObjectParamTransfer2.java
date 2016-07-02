package chap5;

public class ObjectParamTransfer2 {
	Time time1;
	Time time2;
	public static void main(String[] args) {
		ObjectParamTransfer2 opt=new ObjectParamTransfer2();
		opt.time1=new Time();
		opt.time2=new Time();
		opt.time1.hour=12;
		opt.time2.hour=23;
		System.out.println("交换前的属性值：");
		System.out.println("time1.hour="+opt.time1.hour);
		System.out.println("time2.hour="+opt.time2.hour);
		opt.swap1(opt.time1,opt.time2);
		System.out.println("交换后的属性值：");
		System.out.println("time1.hour="+opt.time1.hour);
		System.out.println("time2.hour="+opt.time2.hour);
		opt.swap2(opt.time1,opt.time2);
		System.out.println("交换后的属性值：");
		System.out.println("time1.hour="+opt.time1.hour);
		System.out.println("time2.hour="+opt.time2.hour);
	}
	void swap1(Time t1,Time t2){
		Time temp;
		temp=t1;
		t1=t2;
		t2=temp;
	}
	void swap2(Time t1,Time t2){
		Time temp=new Time();
		temp.hour=t1.hour;
		t1.hour=t2.hour;
		t2.hour=temp.hour;
	}
	
}
