package com.app.customermanagement.controller;

import com.zaxxer.hikari.HikariDataSource;
import com.zaxxer.hikari.HikariPoolMXBean;
import com.zaxxer.hikari.pool.HikariPool;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/poll")
@RequiredArgsConstructor
public class PollController {

    private final HikariDataSource dataSource;

    /**
     * Soft refresh HikariCP pool: đóng các connection cũ khi hết hạn,
     * pool sẽ tự tạo connection mới.
     */
    @GetMapping("/refresh")
    public String refreshPool() {
        try {
            dataSource.getHikariPoolMXBean().softEvictConnections();
            return "HikariCP pool refreshed successfully!";
        } catch (Exception e) {
            return "Failed to refresh pool: " + e.getMessage();
        }
    }
    
    @GetMapping("/check")
    public String checkPool() {
        try {
            HikariPoolMXBean poll = dataSource.getHikariPoolMXBean();
            System.out.println("Number connect: "+ poll.getActiveConnections());
            System.out.println("Number idle connect: "+ poll.getIdleConnections());
            System.out.println("Total connect: "+ poll.getTotalConnections());
            return "test";
        } catch (Exception e) {
            return "Failed to refresh pool: " + e.getMessage();
        }
    }
    
    @GetMapping("/suspend")
    public String suspend() {
        try {
            dataSource.getHikariPoolMXBean().suspendPool();
            return "suspend";
        } catch (Exception e) {
            return "Failed to refresh pool: " + e.getMessage();
        }
    }
    
    @GetMapping("/resume")
    public String resume() {
        try {
            dataSource.getHikariPoolMXBean().resumePool();
            return "resume";
        } catch (Exception e) {
            return "Failed to refresh pool: " + e.getMessage();
        }
    }

}
