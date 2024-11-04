package com.leone.cloud.bus.controller;

import com.leone.cloud.common.entity.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author Leone
 * @since 2018-03-07
 **/
@RefreshScope
@RestController
public class UserController {

    @Value("${alibaba.name}")
    private String name;

    @Value("${alibaba.age}")
    private Integer age;

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

    @GetMapping("/setting")
    public Map<String, Object> setting() {
        return Map.of("name", name, "age", age);
    }


}
