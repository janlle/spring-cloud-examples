package com.andy.ribbon.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.andy.ribbon.entity.User;

/**
 * @author Leone
 * @since 2018-12-21 21:27
 **/
@Slf4j
@RestController
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping("/order/{id}")
    public User order(@PathVariable("id") int id) {
        log.info("[访问到订单微服务，访问用户微服务获取用户信息]");
//        return restTemplate.getForObject("http://localhost:8001/user/" + id, Users.class);
        return restTemplate.getForObject("http://spring-cloud-provider/user/" + id, User.class);
    }

    @GetMapping("/other")
    public String test() {
        ServiceInstance choose1 = loadBalancerClient.choose("spring-cloud-provider1");
        log.info("app1:" + choose1.getHost() + "==" + choose1.getPort() + "==" + choose1.getServiceId());

        ServiceInstance choose2 = loadBalancerClient.choose("springCloud-provider2");
        log.info("app2:" + choose2.getHost() + "==" + choose2.getPort() + "==" + choose2.getServiceId());
        return "success";
    }

    @GetMapping(value="/load", produces = "application/json;charset=UTF-8")
    public String loadBalancer(){
        String url = "http://spring-cloud-provider/info";
        String result = restTemplate.getForObject(url, String.class);
        log.info("[get->{}],:return->{}",url, result);
        return result;
    }


    @GetMapping(value="/rule", produces = "application/json;charset=UTF-8")
    public String ribbonRule(){
        String url = "http://spring-cloud-provider/info";
        ServiceInstance choose = loadBalancerClient.choose("spring-cloud-provider");
        log.info("info->{}",url, choose);
        return "success";
    }

}
