package com.app.customermanagement.service;

import java.util.List;

import com.app.customermanagement.model.Time;

public interface TimeService {
	
	void configTime(String timeStart,String endTime,String timeInterval) throws Exception;
	List<Time> getTime() throws Exception;
	void resetStatusTime() throws Exception;
	void updateTimeisRegister(String time) throws Exception;
}