package com.app.customermanagement.service.serviceimpl;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
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
		// TODO Auto-generated method stub
		
		LocalTime start = LocalTime.parse(timeStart);
		LocalTime end = LocalTime.parse(endTime);
		List<Time> times = new ArrayList<>();
        LocalTime currentTime = start;
        while(!currentTime.isAfter(end)) {
        	times.add(new Time(0, currentTime.format(DateTimeFormatter.ofPattern("HH:mm"))));
            currentTime = currentTime.plusMinutes(Long.parseLong(timeInterval));
        }
        timeRepository.saveAll(times);
		
	}

	@Override
	public List<Time> getTime() {
		// TODO Auto-generated method stub
		return timeRepository.findAll();
	}
	
	
}