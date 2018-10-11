package com.andy.hystrix.config;

import com.andy.hystrix.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name = "spring-cloud-provider", fallback = HystrixClientFallback.class)
public interface UserFeignClient2 {

    @RequestMapping(value = "/user/{userId}", method = RequestMethod.GET)
    User user(@PathVariable("userId") Integer userId);

    @RequestMapping(value = "/user/list", method = RequestMethod.GET)
    List<User> list();

}


