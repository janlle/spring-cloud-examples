package com.leone.cloud.bus.controller;

import com.leone.cloud.common.entity.User;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Leone
 * @since 2018-03-07
 **/
@RestController
public class UserController {

    @Autowired
    private EurekaClient eurekaClient;

//	@Autowired
//	private DiscoveryClient discoveryClient;

//	@GetMapping("/eureka-instance")
//	public String serviceUrl() {
//	    InstanceInfo instance = eurekaClient.getNextServerFromEureka("SPRINGCLOUD-PROVIDER", false);
//	    return instance.getHomePageUrl();
//	}
//	
//	@GetMapping("/eureka-info")
//	public ServiceInstance serviceInfo() {
//	    ServiceInstance info = discoveryClient.getLocalServiceInstance();
//	    return info;
//	}

    @GetMapping("/api/user/{id}")
    public User getUser(@PathVariable("id") int id) {
        return new User();
    }

    @PostMapping("/postUser")
    public User postUser(@RequestBody User user) {
        return user;
    }

    @GetMapping("/list-all")
    public List<User> getAllUser() {
        List<User> user = new ArrayList<>();
        return user;
    }


}
