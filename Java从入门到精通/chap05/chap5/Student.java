package chap5;

public class Student {
	int id=0;
	static int studentNum=0;
	Student(int x)
	{
		id=x;
		studentNum++;
	}
	public static void main(String[] args) {
		Student s1=new Student(1000);
		Student s2=new Student(1001);
		Student s3=new Student(1002);
		Student s4=new Student(1003);
		System.out.println("s1��ѧ�ţ�"+s1.id );
		System.out.println("s2��ѧ�ţ�"+s2.id );
		System.out.println("s3��ѧ�ţ�"+s3.id );
		System.out.println("s4��ѧ�ţ�"+s4.id );
		System.out.println("ѧ������Ŀ��"+Student.studentNum);

	}

}
