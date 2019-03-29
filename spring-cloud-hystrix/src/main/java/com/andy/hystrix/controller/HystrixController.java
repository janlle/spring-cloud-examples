package com.andy.hystrix.controller;

import com.andy.common.entity.User;
import com.andy.hystrix.service.RibbonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Leone
 * @since 2017-12-22
 **/
@Slf4j
@RestController
@RequestMapping("/hystrix")
//@DefaultProperties(defaultFallback = "defaultFallback")
public class HystrixController {

    @Autowired
    private RibbonService ribbonService;


    @GetMapping("/user/{userId}")
    public User fallbackMethod(@PathVariable("userId") Long userId) {
        return ribbonService.find(userId);
    }


}
