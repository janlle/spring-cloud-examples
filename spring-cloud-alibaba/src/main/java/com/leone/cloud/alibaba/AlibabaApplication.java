package com.leone.cloud.alibaba;

import net.javacrumbs.shedlock.spring.annotation.EnableSchedulerLock;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author Leone
 * @since 2018-04-07
 **/
@EnableScheduling
@EnableSchedulerLock(defaultLockAtMostFor = "3m")
@EnableDiscoveryClient
@SpringBootApplication
public class AlibabaApplication {
    public static void main(String[] args) {
        SpringApplication.run(AlibabaApplication.class, args);
    }
}
