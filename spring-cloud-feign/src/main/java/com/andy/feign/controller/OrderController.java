package com.andy.feign.controller;

import com.andy.feign.client.UserFeignClient;
import com.andy.feign.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Leone
 * @since 2017-10-22
 **/
@RestController
@RequestMapping("/feign")
public class OrderController {

    @Autowired
    private UserFeignClient userFeignClient;

//    @Autowired
//    private UserFeignClient1 userFeignClient1;
//
//    @Autowired
//    private UserFeignClient2 userFeignClient2;

    @GetMapping(value = "/user/list", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<User> list() {
        return userFeignClient.list();
    }

    @GetMapping("/user/{id}")
    public User user(@PathVariable("id") int id) {
        return userFeignClient.user(id);
    }

    @PostMapping("/user")
    public User user(@RequestBody User user) {
        return userFeignClient.user(user);
    }

//    @GetMapping("/{serviceName}")
//    public String findEurekaServiceByName(@PathVariable("serviceName") String serviceName) {
//        return userFeignClient1.findEurekaServiceByName(serviceName);
//    }

}
