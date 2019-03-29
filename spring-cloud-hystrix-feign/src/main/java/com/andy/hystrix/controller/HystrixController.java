package com.andy.hystrix.controller;

import com.andy.common.entity.User;
import com.andy.hystrix.feign.UserFeign;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Leone
 * @since 2017-12-22
 **/
@Slf4j
@RestController
@RequestMapping("/hystrix")
public class HystrixController {

    @Autowired
    private UserFeign userFeign;

    @GetMapping("/user")
    public User user(@RequestParam Long userId) {
        return userFeign.find(userId);
    }


}
