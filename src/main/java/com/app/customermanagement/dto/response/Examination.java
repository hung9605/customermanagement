package com.app.customermanagement.dto.response;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.FieldDefaults;

//@Data
//@AllArgsConstructor
//@FieldDefaults(level = AccessLevel.PRIVATE)
public interface  Examination {
	
	Long getTotal();
	Long getNumberExam();
	Long getNumberNotExam();

}
