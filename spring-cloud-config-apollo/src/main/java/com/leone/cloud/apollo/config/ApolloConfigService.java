package com.leone.cloud.apollo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * <p>
 *
 * @author leone
 * @since 2024-12-08
 **/
@Component
@EnableScheduling
public class ApolloConfigService {

    @Value("${name:defName}")
    private String name;

    @Scheduled(cron = "0/5 * * * * ?")
    public void pullConfig() {
        System.out.println("name: " + name);
    }

}