package com.andy.hystrix.controller;

import com.andy.common.entity.User;
import com.andy.hystrix.feign.UserFeign;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    private UserFeign userFeignClient;

    @HystrixCommand(
            fallbackMethod = "fallbackMethod",
            threadPoolProperties = {
                    @HystrixProperty(name = "coreSize", value = "10"),//10个核心线程池,超过20个的队列外的请求被拒绝; 当一切都是正常的时候，线程池一般仅会有1到2个线程激活来提供服务
                    @HystrixProperty(name = "maxQueueSize", value = "100"),
                    @HystrixProperty(name = "queueSizeRejectionThreshold", value = "20")},
            commandProperties = {
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000"), //命令执行超时时间
                    @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "2"), //若干10s一个窗口内失败三次, 则达到触发熔断的最少请求量
                    @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "30000") //断路30s后尝试执行, 默认为5s
            })
    @GetMapping("/user")
    public User user(@RequestParam Long userId) throws Exception {
        return userFeignClient.find(userId);
    }


}
