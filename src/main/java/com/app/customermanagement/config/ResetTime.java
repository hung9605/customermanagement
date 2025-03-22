package com.app.customermanagement.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.app.customermanagement.service.TimeService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ResetTime {
	
	/**
     * logger
     */
    public final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private final TimeService timeService;
	
	@Scheduled(cron = "0 45 09 * * ?")  // Cron expression để chạy vào 10h sáng mỗi ngày
	public void updateTime() {		
		logger.info("----------Starting reset time status");
		try {
			timeService.resetStatusTime();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error(e.getMessage());
		}
		logger.info("----------End reset time");
	}
	

}