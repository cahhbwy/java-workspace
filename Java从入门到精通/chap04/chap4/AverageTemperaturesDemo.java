package chap4;

import java.util.*;

public class AverageTemperaturesDemo {

	public static void main(String[] args) {
		int count;
		double sum,average;
		sum=0;
		double[] temperature=new double[7];
		System.out.println("������������¶ȣ�");
		for(count=0;count<temperature.length;count++)
		{
			temperature[count]=new Scanner(System.in).nextDouble();
			sum+=temperature[count];
		}
		average=sum/7;
		System.out.println("ƽ������Ϊ��"+average);
		for(count=0;count<temperature.length;count++)
		{
			if(temperature[count]<average)
				System.out.println("��"+(count+1)+"�����µ���ƽ������");
			else if(temperature[count]>average)
				System.out.println("��"+(count+1)+"�����¸���ƽ������");
			else
				System.out.println("��"+(count+1)+"�����µ���ƽ������");
		}
	}

}
