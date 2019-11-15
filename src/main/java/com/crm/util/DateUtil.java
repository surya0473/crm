package com.crm.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateUtil {

	private static SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
	private static SimpleDateFormat datetime = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
	private static SimpleDateFormat time = new SimpleDateFormat("HH:mm:ss");

	public static String getCurrentDate() {
		Calendar calobj = Calendar.getInstance();
		return date.format(calobj.getTime());
	}

	public static String getCurrentDateTime() {
		Calendar calobj = Calendar.getInstance();
		return datetime.format(calobj.getTime());
	}

	public static String getCurrentTime() {
		Calendar calobj = Calendar.getInstance();
		return time.format(calobj.getTime());
	}

}
