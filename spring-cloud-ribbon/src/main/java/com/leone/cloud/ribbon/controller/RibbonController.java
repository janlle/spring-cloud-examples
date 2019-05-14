package com.leone.cloud.ribbon.controller;

import com.leone.cloud.common.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * @author Leone
 * @since 2018-12-21
 **/
@Slf4j
@RestController
@RequestMapping("/api/ribbon")
public class RibbonController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping("/{userId}")
    public User order(@PathVariable("userId") int userId) {
        return restTemplate.getForObject("http://mc-user/user/" + userId, User.class);
    }

    @GetMapping("/choose")
    public String choose() {
        ServiceInstance choose = loadBalancerClient.choose("mc-user");
        return "host: " + choose.getHost() + " port: " + choose.getPort() + " serviceId: " + choose.getServiceId();
    }

    @GetMapping("/user")
    public User withOutEureka(@RequestParam Long userId) {
        ServiceInstance choose = loadBalancerClient.choose("mc-user");
        return restTemplate.getForObject(String.format("http://%s:%s/user/%d", choose.getHost(), choose.getPort(), userId), User.class);
    }

}
