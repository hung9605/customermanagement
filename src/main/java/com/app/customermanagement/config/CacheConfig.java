package com.app.customermanagement.config;

import java.time.LocalDateTime;

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
    private static final Logger logger = LoggerFactory.getLogger(CacheConfig.class);
    
    
    @CacheEvict(value = "menuCache", allEntries = true)
    @Scheduled(cron = "${app.cache.cron}") 
    public void resetMenuCache() {
    	logCacheReset("menuCache");
    }
    
    @CacheEvict(value = "moneyCache", allEntries = true)
    @Scheduled(cron = "${app.cache.cron}") 
    public void resetMonneyCache() {
    	logCacheReset("moneyCache");
    }
    
    
    @CacheEvict(value = "moneyExportCache", allEntries = true)
    @Scheduled(cron = "${app.cache.cron}") 
    public void resetMoneyExportCache() {
    	logCacheReset("moneyCacheExport");
    }
    
    @CacheEvict(value = "medicalSuppliesCache", allEntries = true)
    @Scheduled(cron = "${app.cache.cron}") 
    public void resetSuppliesCache() {
    	logCacheReset("suppliesCache");
    }
    
    private void logCacheReset(String cacheName) {
        logger.info("🧹 Reset [{}] cache lúc {}", cacheName, LocalDateTime.now());
    }

    

}