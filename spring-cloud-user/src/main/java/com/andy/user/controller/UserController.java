package com.andy.user.controller;

import com.andy.user.entity.User;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * <p>
 *
 * @author Leone
 * @since 2018-03-10
 **/
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private EurekaClient eurekaClient;

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/instance")
    public String serviceUrl() {
        InstanceInfo instance = eurekaClient.getNextServerFromEureka("SPRING-CLOUD-PROVIDER", false);
        return instance.getHomePageUrl();
    }

    @GetMapping("/info")
    public String serviceInfo() {
        log.info("用户服务-A");
//		log.info("用户服务-B");
        List<String> list = discoveryClient.getServices();
        return "success";
    }

    @GetMapping(value = "/{id}", produces = {"application/json;charset=UTF-8"})
    public User user(@PathVariable("id") int id) {
        log.info("用户服务get();");
        return new User(12, new Date(), "james", "password", "15687793324");
    }

    @DeleteMapping(produces = {"application/json;charset=UTF-8"})
    public void delete(Integer id) {
        log.info("用户服务delete()");
    }

    @PutMapping(produces = {"application/json;charset=UTF-8"})
    public User put(@RequestBody User user) {
        log.info("用户服务put();");
        return user;
    }

    @PostMapping(produces = {"application/json;charset=UTF-8"})
    public User user(@RequestBody User user) {
        log.info("用户服务post()");
        return user;
    }

    @GetMapping(value = "/list", produces = {"application/json;charset=UTF-8"})
    public List<User> list() {
        List<User> user = new ArrayList<>();
        user.add(new User(12, new Date(), "james1", "password", "15687793324"));
        user.add(new User(13, new Date(), "james3", "password", "15687793324"));
        user.add(new User(14, new Date(), "james4", "password", "15687793324"));
        user.add(new User(16, new Date(), "james5", "password", "15687793324"));
        user.add(new User(17, new Date(), "james6", "password", "15687793324"));
        return user;
    }

}
