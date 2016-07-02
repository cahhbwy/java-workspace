package chap4;

public class ArrayCopy3 {

	public static void main(String[] args) {
		int[] array1={1,2,3,4,5,6,7,8,9};
		int[] array2=new int[20];
		for(int i=0;i<10;i++)
			array2[i]=10*i;
		System.arraycopy(array1,0,array2,10,array1.length);
		for(int i=0;i<array2.length;i++)
			System.out.println(array2[i]);
		
	}

}
