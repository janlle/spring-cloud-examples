package com.leone.cloud.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.cloud.openfeign.EnableFeignClients;


/**
 * <p> 生产者 服务提供者 上游服务
 *
 * @author Leone
 * @since 2018-03-10
 **/
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
@RibbonClients({@RibbonClient(name = "mc-order")})
public class UserApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }
}
