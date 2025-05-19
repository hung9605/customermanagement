package com.app.customermanagement.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.app.customermanagement.constants.CommonConstant;

public class DateUtils {
	
	public static String formatDate(String pattern,Date date) {
		return new SimpleDateFormat(pattern).format(date);
	}
	
	public static String getToday() {
	    return DateUtils.formatDate(CommonConstant.DATE_PATTERN, new Date());
	}

}
