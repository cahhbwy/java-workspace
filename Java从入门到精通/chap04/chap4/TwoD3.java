package chap4;

public class TwoD3 {

	public static void main(String[] args) {
		int[][]twoD=new int[4][];
		twoD[0]=new int[1];
		twoD[1]=new int[2];
		twoD[2]=new int[3];
		twoD[3]=new int[4];
		int k=1;
		for(int i=0;i<twoD.length;i++)
			for(int j=0;j<twoD[i].length;j++)
				twoD[i][j]=k++;
		System.out.println("得到的不规则二维数组为：");
		for(int i=0;i<twoD.length;i++)
		{
			for(int j=0;j<twoD[i].length;j++)
				System.out.print(twoD[i][j]+"\t");
			System.out.println();
			
		}
	}

}
