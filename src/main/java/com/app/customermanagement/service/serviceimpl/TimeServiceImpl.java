package com.app.customermanagement.service.serviceimpl;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.app.customermanagement.model.Time;
import com.app.customermanagement.repository.TimeRepository;
import com.app.customermanagement.service.TimeService;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
@Service
public class TimeServiceImpl implements TimeService{
	
	private final TimeRepository timeRepository;
	

	@Override
	public void configTime(String timeStart, String endTime, String timeInterval) throws Exception{
		timeRepository.deleteAllTimes();
		LocalTime start = LocalTime.parse(timeStart);
		LocalTime end = LocalTime.parse(endTime);
		List<Time> times = new ArrayList<>();
        LocalTime currentTime = start;
        while(!currentTime.isAfter(end)) {
        	times.add(new Time(null, currentTime.format(DateTimeFormatter.ofPattern("HH:mm")),false));
            currentTime = currentTime.plusMinutes(Long.parseLong(timeInterval));
        }
        timeRepository.saveAll(times);
		
	}

	@Override
	public List<Time> getTime() throws Exception{
		return timeRepository.findByStatusFalse();
	}

	@Override
	public void resetStatusTime() throws Exception{
		timeRepository.updateAllStatusToFalse();
	}

	@Override
	public void updateTimeisRegister(String time) throws Exception {
		timeRepository.updateTimeisRegister(time);
	}
	
	
}