package com.andy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Leone
 * @since 2018-04-07
 **/
@EnableEurekaClient
@SpringBootApplication
public class SpringCloudApp {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudApp.class, args);
    }
}
