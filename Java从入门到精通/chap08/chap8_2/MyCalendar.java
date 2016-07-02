package chap8_2;

import java.util.*;

public class MyCalendar {
	
	public static void main(String[] args) {
		GregorianCalendar now =new GregorianCalendar();
		//获得一个Date对象
		Date date =new Date();
//		System.out.println(now.toString());
		System.out.println(date.toString());
		//用date设now的时间
//		now.setTime(date);
		//从now中取出当前的日期、月份
		int today=now.get(Calendar.DAY_OF_MONTH);//int java.util.Calendar.DAY_OF_MONTH = 5 [0x5]
		int month=now.get(Calendar.MONTH);//int java.util.Calendar.MONTH = 2 [0x2]
		//设置now的日期为1
		now.set(Calendar.DAY_OF_MONTH,1);
		//得到now是一周的第几天
		int week=now.get(Calendar.DAY_OF_WEEK);//int java.util.Calendar.DAY_OF_WEEK = 7 [0x7]
		//打印出日历头
		System.out.println(" Sun   Mon   Tue   Wed   Thu   Fri   Sat");
		//打印出前面的空格
		for(int i=Calendar.SUNDAY;i<week;i++){//int java.util.Calendar.SUNDAY = 1 [0x1]
			System.out.print("      ");
		}
		while(now.get(Calendar.MONTH)==month){
			int day=now.get(Calendar.DAY_OF_MONTH);
			//为了对齐，要对大于10和小于10的数打印不同的空格数
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
			//周六换行
			if(week==Calendar.SATURDAY){//int java.util.Calendar.SATURDAY = 7 [0x7]
				System.out.println();
			}
			now.add(Calendar.DAY_OF_WEEK, 1);
			week=now.get(Calendar.DAY_OF_WEEK);
			
		}
	}

}
