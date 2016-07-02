package chap5;
class Human{
	String name;
	String sex;
	int age;
	String addr;
	void work(){
		System.out.println("我在工作");
	}
	void eat(){
		System.out.println("我在吃饭");
	}
	String getState(int time){
		String state=null;
		if(time>=0&&24>=time){
			if(time>8&&time<17)
				state="我在工作";
			else if(time>17&&time<22)
				state="我在学习";
			else
				state="我在睡觉";
		}
		else
			state="错误的时间";
		return state;
	}
}
public class MethodDemo {

	public static void main(String[] args) {
		Human wangming=new Human();
		wangming.name="王明";
		wangming.age=25;
		wangming.sex="男";
		wangming.addr="中国北京";
		System.out.println(wangming.name+"晚上23点钟你在干嘛");
		System.out.println(wangming.getState(23));
		System.out.println("下午15点呢");
		System.out.println(wangming.getState(15));
		
	}

}
