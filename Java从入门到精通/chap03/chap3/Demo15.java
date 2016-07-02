package chap3;

public class Demo15 {

	public static void main(String[] args) {
		out:for(int i=1;i<10;i++)
			for(int j=0;j<10;j++)
				if(j>=i)
				{
					System.out.println();
					continue out;
				}
				else
					System.out.print(" i="+i+" j="+j);
	}

}
