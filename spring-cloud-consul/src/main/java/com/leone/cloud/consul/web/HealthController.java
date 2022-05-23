package com.leone.cloud.consul.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *
 * @author leone
 * @since 2022-05-23
 **/
@RestController
public class HealthController {

    @GetMapping("/hello")
    public String home() {
        return "hi ,i am from Consul:";
    }

}
