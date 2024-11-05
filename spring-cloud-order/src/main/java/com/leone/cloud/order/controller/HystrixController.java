package com.leone.cloud.order.controller;

import com.leone.cloud.common.entity.Order;
import com.leone.cloud.common.entity.User;
import com.leone.cloud.order.service.OrderService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

/**
 * @author leone
 * @since 2017-12-22
 **/
@Slf4j
@RestController
@RequestMapping("/hystrix")
@DefaultProperties(defaultFallback = "defaultFallback")
public class HystrixController {

    private final Random random = new Random();

    @Autowired
    private OrderService orderService;


    @GetMapping("/order/{orderId}")
    public Order findOne(@PathVariable("orderId") Long orderId) {
        return orderService.findOne(orderId);
    }

    @HystrixCommand(
            fallbackMethod = "testFallback",
            threadPoolProperties = {
                    //10个核心线程池,超过20个的队列外的请求被拒绝; 当一切都是正常的时候，线程池一般仅会有1到2个线程激活来提供服务
                    @HystrixProperty(name = "coreSize", value = "10"),
                    @HystrixProperty(name = "maxQueueSize", value = "100"),
                    @HystrixProperty(name = "queueSizeRejectionThreshold", value = "20")},
            commandProperties = {
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000"), //命令执行超时时间
                    @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "2"), //若干10s一个窗口内失败三次, 则达到触发熔断的最少请求量
                    @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "30000") //断路30s后尝试执行, 默认为5s
            })
    @GetMapping("/user/test")
    public String test() throws Exception {
        Thread.sleep(2500);
        return "success";
    }


    public String testFallback() {
        return "fallback";
    }


    @HystrixCommand
    @GetMapping("/test1")
    public String test1() {
        if (random.nextInt(100) < 30) {
            int i = 1 / 0;
        }
        return "test1";
    }

    @HystrixCommand
    @GetMapping("/test2")
    public String test2() {
        if (random.nextInt(100) < 20) {
            int i = 1 / 0;
        }
        return "test2";
    }


    public String defaultFallback() {
        return "default";
    }


}
