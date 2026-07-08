package com.library.library_app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public NotificationSender notificationSender (LibInfo libInfo){
       System.out.println("LibInfo is used for Config :"+libInfo.getSummary());

        return new NotificationSender("EMail");


    }
}
