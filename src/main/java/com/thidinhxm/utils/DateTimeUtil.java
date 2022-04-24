package com.thidinhxm.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateTimeUtil {
	
	public static String getLocalDateString(LocalDate date) { 
		return date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
	}
}
