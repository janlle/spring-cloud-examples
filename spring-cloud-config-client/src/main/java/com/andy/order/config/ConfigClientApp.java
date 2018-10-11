package com.andy.order.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Leone
 * @since 2018-1-23
 **/
@EnableDiscoveryClient
@SpringBootApplication
public class ConfigClientApp {
    public static void main(String[] args) {
        SpringApplication.run(ConfigClientApp.class, args);
    }
}
