package chap4;

public class TwoD2 {

	public static void main(String[] args) {
		int[][] twoD1={
				{1,2,3,4,5},
				{6,7,8,9,10},
				{11,12,13,14,15},
				{16,17,18,19,20},
				{21,22,23,24,25}
		};
		int[] array1=new int[5];
		array1=twoD1[0];
		twoD1[0]=twoD1[4];
		twoD1[4]=array1;
		System.out.println("得到的一维数组 array1");
		for(int i=0;i<array1.length;i++)
			System.out.print(array1[i]+"\t");
		System.out.println();
		System.out.println("交换后的二维数组 twoD1");
		for(int i=0;i<twoD1.length;i++)
		{
			for(int j=0;j<twoD1[i].length;j++)
				System.out.print(twoD1[i][j]+"\t");
			System.out.println();
		}
	}

}
