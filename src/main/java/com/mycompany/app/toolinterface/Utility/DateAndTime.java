package com.mycompany.app.toolinterface.Utility;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateAndTime {
	public static String getDateTime(){
		
		String dateAndTime;
		String DATE_FORMAT_NOW = "yyy-MM-dd HH-mm-ss";
		
		// get date and time
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
		dateAndTime = sdf.format(cal.getTime());
		 
		return dateAndTime; 

	}	
	
	public static String getDateTime(String format){
		
		String dateAndTime;
		String DATE_FORMAT_NOW = format;
		
		// get date and time
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
		dateAndTime = sdf.format(cal.getTime());
		 
		return dateAndTime; 
	}
}
