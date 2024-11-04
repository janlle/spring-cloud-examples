package com.leone.cloud.bus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Leone
 * @since 2018-04-07
 **/
@EnableDiscoveryClient
@SpringBootApplication
public class AlibabaApplication {
    public static void main(String[] args) {
        SpringApplication.run(AlibabaApplication.class, args);
    }
}
