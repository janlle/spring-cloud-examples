package com.leone.cloud.hystrix;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.Random;

/**
 * <p>
 *
 * @author Leone
 * @since 2018-02-11
 **/
@EnableHystrix
@EnableFeignClients
@EnableDiscoveryClient
public class HystrixFeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(HystrixFeignApplication.class, args);
    }

    @Bean
    public Random random() {
        return new Random();
    }

}
