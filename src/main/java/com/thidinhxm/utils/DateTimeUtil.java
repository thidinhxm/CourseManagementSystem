package com.thidinhxm.utils;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateTimeUtil {
	private static Calendar calendar = new GregorianCalendar();
	
	public static String getDateString(Date date) { // dd-mm-yyyy || mm-dd-yyyy || yyyy-mm-dd 
		calendar.setTime(date);
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH) + 1;
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		
		return format(day) + "-" + format(month) + "-" + year;
		
	}
	
	private static String format(int number) {
		if (number < 10) {
			return "0" + number;
 		}
		return number + "";
	}
}
