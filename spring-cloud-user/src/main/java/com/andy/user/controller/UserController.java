package com.andy.user.controller;

import com.andy.user.entity.EntityFactory;
import com.andy.user.entity.User;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
        InstanceInfo instance = eurekaClient.getNextServerFromEureka("USER-SERVICE", false);
        return instance.getHomePageUrl();
    }

    @GetMapping("/info")
    public List<String> serviceInfo() {
        log.info("user service-A");
//		log.info("user service-B");
        return discoveryClient.getServices();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public User user(@PathVariable("id") int id) {
        return EntityFactory.getUser(id);
    }

    @GetMapping("/list")
    public List<User> list() {
        return EntityFactory.getUsers(10);
    }


    @DeleteMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void delete(Integer id) {
        log.info("user service delete");
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public User put(@RequestBody User user) {
        log.info("user service put");
        return user;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public User user(@RequestBody User user) {
        log.info("user service post");
        return user;
    }



}
