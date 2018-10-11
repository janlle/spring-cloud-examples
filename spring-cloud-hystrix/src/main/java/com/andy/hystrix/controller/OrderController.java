package com.andy.hystrix.controller;

import com.andy.hystrix.entity.User;
import com.andy.hystrix.config.UserFeignClient1;
import com.andy.hystrix.config.UserFeignClient2;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.Random;

/**
 * @author Leone
 * @since 2017-12-22
 **/
@Slf4j
@RestController
@DefaultProperties(defaultFallback = "defaultFallback")
public class OrderController {

    @Autowired
    private UserFeignClient1 userFeignClient1;

    @Autowired
    private UserFeignClient2 userFeignClient2;

    @Autowired
    private RestTemplate restTemplate;

//    @HystrixCommand(
//            fallbackMethod = "fallbackMethod",
//            threadPoolProperties = {
//                    @HystrixProperty(name = "coreSize", value = "10"),//10个核心线程池,超过20个的队列外的请求被拒绝; 当一切都是正常的时候，线程池一般仅会有1到2个线程激活来提供服务
//                    @HystrixProperty(name = "maxQueueSize", value = "100"),
//                    @HystrixProperty(name = "queueSizeRejectionThreshold", value = "20")},
//            commandProperties = {
//                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000"), //命令执行超时时间
//                    @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "2"), //若干10s一个窗口内失败三次, 则达到触发熔断的最少请求量
//                    @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "30000") //断路30s后尝试执行, 默认为5s
//            })
    @GetMapping("/user/{userId}")
    public User user(@PathVariable("userId") Integer userId) throws Exception {
//        Thread.sleep(2000);
        User user = userFeignClient2.user(userId);
        return user;
//        return new User(2, new Date(), "aaa", "bb", 22000.00);
    }

    public User fallbackMethod(Integer userId) {
        log.info("服务降级");
        return new User(12, new Date(), "james", "password", "15687793324");
    }

    public User defaultFallbackMethod(Integer userId) {
        log.info("服务降级");
        return new User(12, new Date(), "james", "password", "15687793324");
    }

    @GetMapping("/user")
    public User one() {
        return restTemplate.getForObject("http://spring-cloud-provider/user/" + new Random().nextInt(100), User.class);
    }

}
