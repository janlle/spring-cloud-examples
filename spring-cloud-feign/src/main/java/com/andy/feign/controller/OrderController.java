package com.andy.feign.controller;

import com.andy.feign.client.UserFeignClient;
import com.andy.feign.client.UserFeignClient1;
import com.andy.feign.client.UserFeignClient2;
import com.andy.feign.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Leone
 * @since 2017-10-22
 **/
@RestController
public class OrderController {

    @Autowired
    private UserFeignClient userFeignClient;

    @GetMapping("/user/{id}")
    public User user(@PathVariable("id") int id) {
        User user = userFeignClient.user(id);
        return user;
    }

    @PostMapping(value = "/user")
    public User user(@RequestBody User user) {
        return userFeignClient.user(user);
    }

    @Autowired
    private UserFeignClient1 userFeignClient1;

    @Autowired
    private UserFeignClient2 userFeignClient2;


    @GetMapping("/users/{id}")
    public User get(@PathVariable("id") int id) {
        User user = userFeignClient2.user(id);
        return user;
    }

    @PostMapping("/users")
    public User get(@RequestBody User users) {
        return userFeignClient2.user(users);
    }

    @GetMapping("/{serviceName}")
    public String findEurekaServiceByName(@PathVariable("serviceName") String serviceName) {
        return userFeignClient1.findEurekaServiceByName(serviceName);
    }

}
