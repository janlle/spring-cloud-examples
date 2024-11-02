package com.leone.cloud.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;

import java.util.Arrays;


/**
 * <p> 生产者 服务提供者 上游服务
 *
 * @author Leone
 * @since 2018-03-10
 **/
@EnableDiscoveryClient
@SpringBootApplication
@RibbonClients({@RibbonClient(name = "mc-user")})
public class UserApplication {
    public static void main(String[] args) {
        if (args.length > 0) {
            System.out.println(Arrays.toString(args));
        }
        SpringApplication.run(UserApplication.class, args);
    }
}
