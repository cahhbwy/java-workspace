package chap5;
class Human{
	String name;
	String sex;
	int age;
	String addr;
	void work(){
		System.out.println("���ڹ���");
	}
	void eat(){
		System.out.println("���ڳԷ�");
	}
	String getState(int time){
		String state=null;
		if(time>=0&&24>=time){
			if(time>8&&time<17)
				state="���ڹ���";
			else if(time>17&&time<22)
				state="����ѧϰ";
			else
				state="����˯��";
		}
		else
			state="�����ʱ��";
		return state;
	}
}
public class MethodDemo {

	public static void main(String[] args) {
		Human wangming=new Human();
		wangming.name="����";
		wangming.age=25;
		wangming.sex="��";
		wangming.addr="�й�����";
		System.out.println(wangming.name+"����23�������ڸ���");
		System.out.println(wangming.getState(23));
		System.out.println("����15����");
		System.out.println(wangming.getState(15));
		
	}

}
