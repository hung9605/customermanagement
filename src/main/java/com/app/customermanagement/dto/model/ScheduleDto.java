package com.app.customermanagement.dto.model;

import com.app.customermanagement.model.Customer;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ScheduleDto {

	 	Integer id;
	    String fullName;
	    String phoneNumber;
	    String timeRegister;
	    String dateRegister;
	    Integer status;
	    Customer customer;
	    String gender;


}
