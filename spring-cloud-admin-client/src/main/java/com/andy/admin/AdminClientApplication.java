package com.andy.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

/**
 * <p>
 *
 * @author Leone
 * @since 2018-10-11
 **/

@SpringCloudApplication
public class AdminClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdminClientApplication.class, args);
    }

}
