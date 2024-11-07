package com.app.customermanagement.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
	
	public static String formatDate(String pattern,Date date) {
		return new SimpleDateFormat(pattern).format(date);
	}

}
