package com.app.customermanagement.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CacheConfig {
	
	/**
     * logger
     */
    public final Logger logger = LoggerFactory.getLogger(this.getClass());
    
    
    @CacheEvict(value = "menuCache", allEntries = true)
    @Scheduled(cron = "0 30 * * * *") 
    public void resetMenuCache() {
        System.out.println("🧹 Reset menu cache lúc " + java.time.LocalDateTime.now());
    }
    
    @CacheEvict(value = "moneyCache", allEntries = true)
    @Scheduled(cron = "0 30 * * * *") 
    public void resetMonneyCache() {
        System.out.println("🧹 Reset money cache lúc " + java.time.LocalDateTime.now());
    }
    
    
    @CacheEvict(value = "moneyExportCache", allEntries = true)
    @Scheduled(cron = "0 30 * * * *") 
    public void resetMoneyExportCache() {
        System.out.println("🧹 Reset money export cache lúc " + java.time.LocalDateTime.now());
    }
    
    @CacheEvict(value = "medicalSuppliesCache", allEntries = true)
    @Scheduled(cron = "0 30 * * * *") 
    public void resetsuppliesCache() {
        System.out.println("🧹 Reset medical supplies cache lúc " + java.time.LocalDateTime.now());
    }
    
    
    

}