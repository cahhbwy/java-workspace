package chap4;

public class ArrayInital {

	public static void main(String[] args) {
		int[] array1=new int[5];
		array1[0]=1;
		array1[1]=2;
		array1[2]=3;
		array1[3]=4;
		array1[4]=5;
		int[] array2={1,2,3,4,5};
		for(int i=0;i<5;i++)
			System.out.println("array1["+i+"]="+array1[i]);
		for(int i=0;i<5;i++)
			System.out.println("array2["+i+"]="+array2[i]);
	}
}
