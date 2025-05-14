package com.app.customermanagement.util;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;

public class StringUtils {
	
	
	public static String getMessage(MessageSource messageSource,String key) {
        return messageSource.getMessage(key, null, LocaleContextHolder.getLocale());
    }


}
