package com.andy.ribbon.controller;

import com.andy.common.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author Leone
 * @since 2018-12-21
 **/
@Slf4j
@RestController
@RequestMapping("/ribbon")
public class RibbonController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping("/user/{userId}")
    public User order(@PathVariable("userId") int userId) {
        return restTemplate.getForObject("http://mc-user/user/" + userId, User.class);
    }

    @GetMapping("/choose")
    public String test() {
        ServiceInstance choose = loadBalancerClient.choose("mc-user");
        return "host: " + choose.getHost() + " port: " + choose.getPort() + " serviceId: " + choose.getServiceId();
    }

}
