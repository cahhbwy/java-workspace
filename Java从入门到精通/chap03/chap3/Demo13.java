package chap3;

public class Demo13 {

	public static void main(String[] args) {
		out:{
			for(int i=0;i<20;i++)
			{
				System.out.println("外循环"+i);
				for(int j=0;j<20;j++)
				{
					System.out.println("内循环"+j);
					if(j==10)
						break out;
				}
			}
		}
	}

}
