package chap3;

public class Demo12 {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		first:{
			second:{
				third:{
					for(int i=0;i<3;i++)
					{
						System.out.println("third:"+i);
						if(i==2)
							break second;
					}
				}
				System.out.println("��second������");
			}
		System.out.println("��first������");
		}
	}

}
