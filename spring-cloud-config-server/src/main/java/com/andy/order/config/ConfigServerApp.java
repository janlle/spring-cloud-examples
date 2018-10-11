package com.andy.order.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Leone
 * @since 2017-12-07
 **/
@RestController
@EnableConfigServer
@EnableDiscoveryClient
@SpringBootApplication
public class ConfigServerApp {

    public static void main(String[] args) {
        SpringApplication.run(ConfigServerApp.class, args);
        System.out.println(System.getProperty("user.dir"));
    }

    @RequestMapping("/")
    public String home() {
        return "Hello World!";
    }

}
