package chap4;

public class ForEach {

	public static void main(String[] args) {
		int sum=0;
		int[] num={1,2,3,4,5,6,7,8,9,0};
		for(int i:num)
		{
			System.out.println("����Ԫ�أ�"+i);
			sum+=i;
		}
		System.out.println("����Ԫ�غͣ�"+sum);
		
	}

}
