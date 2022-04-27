package com.thidinhxm.utils;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateTimeUtil {
	
	public static String getLocalDateString(LocalDate date) { 
		return date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
	}
	
	public static String getVietnameseDayOfWeek(DayOfWeek date) {
		String day = date.toString();
		
		System.out.println(day.equals("TUESDAY"));
		if (day.equals("MONDAY")) {
			return "Thứ hai";
		}
		if (day.equals("TUESDAY")) {
			return "Thứ ba";
		}
		if (day.equals("WEDNESDAY")) {
			return "Thứ tư";
		}
		if (day.equals("THIRDAY")) {
			return "Thứ năm";
		}
		if (day.equals("FRIDAY")) {
			return "Thứ sáu";
		}
		if (day.equals("SATURDAY")) {
			return "Thứ bảy";
		}
		return "Chủ nhật";
	}
}
