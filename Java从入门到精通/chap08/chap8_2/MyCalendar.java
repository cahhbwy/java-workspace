package chap8_2;

import java.util.*;

public class MyCalendar {
	
	public static void main(String[] args) {
		GregorianCalendar now =new GregorianCalendar();
		//���һ��Date����
		Date date =new Date();
//		System.out.println(now.toString());
		System.out.println(date.toString());
		//��date��now��ʱ��
//		now.setTime(date);
		//��now��ȡ����ǰ�����ڡ��·�
		int today=now.get(Calendar.DAY_OF_MONTH);//int java.util.Calendar.DAY_OF_MONTH = 5 [0x5]
		int month=now.get(Calendar.MONTH);//int java.util.Calendar.MONTH = 2 [0x2]
		//����now������Ϊ1
		now.set(Calendar.DAY_OF_MONTH,1);
		//�õ�now��һ�ܵĵڼ���
		int week=now.get(Calendar.DAY_OF_WEEK);//int java.util.Calendar.DAY_OF_WEEK = 7 [0x7]
		//��ӡ������ͷ
		System.out.println(" Sun   Mon   Tue   Wed   Thu   Fri   Sat");
		//��ӡ��ǰ��Ŀո�
		for(int i=Calendar.SUNDAY;i<week;i++){//int java.util.Calendar.SUNDAY = 1 [0x1]
			System.out.print("      ");
		}
		while(now.get(Calendar.MONTH)==month){
			int day=now.get(Calendar.DAY_OF_MONTH);
			//Ϊ�˶��룬Ҫ�Դ���10��С��10������ӡ��ͬ�Ŀո���
			if(day<10){
				if(day==today)
					System.out.print("  -"+day+"- ");
				else
					System.out.print("   "+day+"  ");
			}
			else{
				if(day==today)
					System.out.print(" -"+day+"- ");
				else
					System.out.print("  "+day+"  ");
			}
			//��������
			if(week==Calendar.SATURDAY){//int java.util.Calendar.SATURDAY = 7 [0x7]
				System.out.println();
			}
			now.add(Calendar.DAY_OF_WEEK, 1);
			week=now.get(Calendar.DAY_OF_WEEK);
			
		}
	}

}
