package com.andy.order.controller;

import com.andy.order.entity.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Date;

/**
 * @author Leone
 * @since 2017-12-22 22:33
 **/
@Slf4j
@RestController
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/user/{id}")
    @HystrixCommand(fallbackMethod = "findByIdFallback"/*, commandProperties=@HystrixProperty(name="execution.isolation.strategy", value="SEMAPHORE")*/)
    public User user(@PathVariable("id") int id) {
        log.info("订单服务获取用户信息->http://spring-cloud-provider/user/{}", id);
        return restTemplate.getForObject("http://spring-cloud-provider/user/" + id, User.class);
    }

    //fallback 方法的返回值和参数要和原始方法一致
    public User findByIdFallback(int id) {
        log.info("订单服务获取用户信息的fallback方法->param:id={}", id);
        return new User(12, new Date(), "james", "password", "15687793324");
    }

}
