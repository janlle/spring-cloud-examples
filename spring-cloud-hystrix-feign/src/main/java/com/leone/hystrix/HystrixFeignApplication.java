package com.leone.hystrix;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
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
@SpringCloudApplication
public class HystrixFeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(HystrixFeignApplication.class, args);
    }

    @Bean
    public Random random() {
        return new Random();
    }

}
