package chap4;

import java.util.*;

public class AverageTemperatures {

	public static void main(String[] args) {
		int count;
		double next,sum,average;
		sum=0;
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
		System.out.println("������������¶ȣ�");
		for(count=0;count<7;count++)
		{
			next=sc.nextDouble();
			sum+=next;
		}
		System.out.println(sum);
		average=sum/7;
		System.out.println("ƽ������Ϊ��"+average);
	}

}
