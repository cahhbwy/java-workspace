package chap5;
class Time
{
	public int hour;
	public int minute;
	public int second;
}
public class ObjectParamTransfer {
	Time time;
	public static void main(String[] args) {
		ObjectParamTransfer opt=new ObjectParamTransfer();
		opt.time=new Time();
		opt.time.hour=12;
		opt.time.minute=45;
		opt.time.second=20;
		System.out.println("time 的属性值:");
		System.out.println("hour="+opt.time.hour);
		System.out.println("minute="+opt.time.minute);
		System.out.println("second="+opt.time.second);
		opt.objectMethod(opt.time);
		System.out.println("执行方法后的time的属性值:");
		System.out.println("hour="+opt.time.hour);
		System.out.println("minute="+opt.time.minute);
		System.out.println("second="+opt.time.second);
		
	}
	void objectMethod(Time t){
		System.out.println("参数t的属性值:");
		System.out.println("hour="+t.hour);
		System.out.println("minute="+t.minute);
		System.out.println("second="+t.second);
		System.out.println("对t和time进行==比较，结果为："+(t==this.time));
		System.out.println("对t和time进行equals比较,结果为："+(t.equals(this.time)));
		System.out.println("改变t的实例变量值");
		t.hour=8;
		t.minute=12;
		t.second=24;
	}
}
