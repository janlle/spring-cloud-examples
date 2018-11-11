package com.andy.hystrix.controller;

//import com.andy.hystrix.config.UserFeignClient;

import com.andy.hystrix.config.UserFeignClient;
import com.andy.hystrix.entity.User;
import com.andy.hystrix.pojo.UserAddVO;
import com.andy.hystrix.pojo.UserEditVO;
import com.andy.hystrix.pojo.UserVO;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Leone
 * @since 2017-12-22
 **/
@Slf4j
@RestController
//@DefaultProperties(defaultFallback = "defaultFallback")
public class HystrixController {

//    @Autowired
//    private UserFeignClient userFeignClient;

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
//    @GetMapping("/user/{userId}")
//    public User user(@PathVariable("userId") Long userId) throws Exception {
//        return userFeignClient.find(userId);
//    }
//
//    public User fallbackMethod(Integer userId) {
//        log.info("服务降级");
//        return EntityFactory.getUser();
//    }
//
//    public User defaultFallbackMethod(Integer userId) {
//        log.info("服务降级");
//        return EntityFactory.getUser();
//    }
//
//    @GetMapping("/user")
//    public User find() {
//        return restTemplate.getForObject("http://user/user/" + new Random().nextInt(100), User.class);
//    }

//    @GetMapping(value = "/user/list", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//    public List<User> list() {
//        return userFeignClient.list();
//    }
//
//    @GetMapping("/user/{id}")
//    public User user(@PathVariable("id") Long id) {
//
//        return userFeignClient.find(id);
//    }
//
//    @PutMapping("/user")
//    public UserVO update(@RequestBody UserEditVO user) {
//        return userFeignClient.update(user);
//    }
//
//    @PostMapping("/user")
//    public UserVO save(@RequestBody UserAddVO user) {
//        return userFeignClient.save(user);
//    }
//
//    @DeleteMapping("/user")
//    public void delete(@RequestParam("userId") Long userId) {
//        log.info("user feign delete");
//        Map<String, Long> param = new HashMap<>();
//        param.put("userId", userId);
//        userFeignClient.delete(param);
//    }
//
//    @PostMapping("/user/upload")
//    public String upload(MultipartFile file) {
//        return userFeignClient.upload(file);
//    }


}
