package com.andy.order.controller;

import com.andy.order.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author Leone
 * @since 2018-06-20
 **/
@Slf4j
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping(value = "/user/{id}", produces = "application/json;charset=UTF-8")
    public User user(@PathVariable("id")int id) {
        String url = "http://localhost:8001/user/" + id;
        ServiceInstance instance = loadBalancerClient.choose("spring-cloud-provider");
        log.info("instance->host:{},port:{},serviceId:{},scheme:{},url:{},metadata:{}",instance.getHost(),instance.getPort(),instance.getServiceId(),instance.getScheme(),instance.getUri(),instance.getMetadata());
        User user = restTemplate.getForObject(url, User.class);
        log.info("[get->{}],:return->{}",url, user);
        return user;
    }

    @GetMapping(value="/user/list", produces = "application/json;charset=UTF-8")
    public List<User> list(){
        String url = "http://localhost:8001/list";
        ParameterizedTypeReference<List<User>> typeRef = new ParameterizedTypeReference<List<User>>() {};
        List<User> users = restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<User>>() {}).getBody();
        log.info("[get->{}],:return->{}",url, users);
        return users;
    }

    @GetMapping(value="/load", produces = "application/json;charset=UTF-8")
    public String loadBalancer(){
        String url = "http://localhost:8001/info";
        String result = restTemplate.getForObject("http://localhost:8001/info", String.class);
        log.info("[get->{}],:return->{}",url, result);
        return result;
    }


}
