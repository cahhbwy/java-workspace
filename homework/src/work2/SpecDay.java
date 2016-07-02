package work2;

public class SpecDay {
	public static void main(String[] args) {
		int year = Integer.parseInt(args[0]);
		int month = Integer.parseInt(args[1]);
		int day = Integer.parseInt(args[2]);
		int n = Integer.parseInt(args[3]);
		n = n * 100 - 1;
		while (n > 31) {
			if (month == 1 || month == 3 || month == 5 || month == 7
					|| month == 8 || month == 10 || month == 12)
				n = n - (31 - day);
			else if (month == 4 || month == 6 || month == 9 || month == 11)
				n = n - (30 - day);
			else {
				if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0))
					n = n - (29 - day);
				else
					n = n - (28 - day);
			}
			day = 0;
			month++;
			if (month > 12) {
				month = 1;
				year++;
			}
		}
		if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8
				|| month == 10 || month == 12)
			day = n;
		else if (month == 4 || month == 6 || month == 9 || month == 11)
			if (n > 30) {
				month++;
				day = n - 30;
			} else
				day = n;
		else if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0))
			if (n > 29) {
				month++;
				day = n - 29;
			} else
				day = n;
		else if (n > 28) {
			month++;
			day = n - 28;
		} else
			day = n;
		System.out
				.println("Year:" + year + "\nMonth:" + month + "\nDay:" + day);
	}

}
