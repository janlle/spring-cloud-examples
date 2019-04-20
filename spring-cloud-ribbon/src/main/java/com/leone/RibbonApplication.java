package com.leone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Leone
 * @since 2018-12-21
 **/
@SpringBootApplication
//@EnableDiscoveryClient
//@RibbonClients({@RibbonClient(name = "mc-user")})
public class RibbonApplication {
    public static void main(String[] args) {
        SpringApplication.run(RibbonApplication.class, args);
    }
}
