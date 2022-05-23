package com.leone.cloud.consul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * <p>注册服务到consul上
 *
 * @author leone
 * @since 2018-10-26
 **/
@SpringBootApplication
public class ConsulApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConsulApplication.class, args);
    }
}
