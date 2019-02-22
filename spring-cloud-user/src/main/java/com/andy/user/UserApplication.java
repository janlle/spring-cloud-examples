package com.andy.user;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
 * <p> 生产者 服务提供者 上游服务
 *
 * @author Leone
 * @since 2018-03-10
 **/
@EnableSwagger2
@EnableCircuitBreaker
@SpringCloudApplication
public class UserApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }
}
