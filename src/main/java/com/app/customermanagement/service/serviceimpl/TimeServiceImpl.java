package com.app.customermanagement.service.serviceimpl;

import com.app.customermanagement.repository.TimeRepository;
import com.app.customermanagement.service.TimeService;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class TimeServiceImpl implements TimeService{
	
	private final TimeRepository timeRepository;
	
	@Override
	public void configTime(String timeStart, String endTime, String timeInterval) {
		// TODO Auto-generated method stub
		
	}
	
	
}
