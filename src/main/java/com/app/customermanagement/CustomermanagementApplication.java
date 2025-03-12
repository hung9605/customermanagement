package com.app.customermanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class CustomermanagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomermanagementApplication.class, args);
    }

}
