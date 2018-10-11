package com.andy.hystrix.config;

import com.andy.hystrix.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

//configuration = ConfigurationFei1.class,
@FeignClient(name = "spring-cloud-provider", fallbackFactory = HystrixClientFallbackFactory.class)
public interface UserFeignClient1 {

    @RequestMapping(value = "/user/{userId}", method = RequestMethod.GET)
    User user(@PathVariable("userId") Integer userId);

    @RequestMapping(value = "/user/list", method = RequestMethod.GET)
    List<User> list();

}


