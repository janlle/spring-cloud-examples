package com.leone.cloud.order.controller;

import com.leone.cloud.common.beans.order.OrderVO;
import com.leone.cloud.common.beans.user.UserVO;
import com.leone.cloud.common.entity.Order;
import com.leone.cloud.common.entity.User;
import com.leone.cloud.order.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

/**
 * @author Leone
 * @since 2018-06-20
 **/
@Slf4j
@RestController
public class LoadBalancerController {

    @Autowired
    private RestTemplate restTemplate;

    // @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping("/user")
    public Object user() {
        return restTemplate.getForObject("http://mc-user/user", String.class);
    }

    @GetMapping("/choose")
    public String choose() {
        ServiceInstance choose = loadBalancerClient.choose("mc-user");
        System.out.println(choose);
        return "host: " + choose.getHost() + " port: " + choose.getPort() + " serviceId: " + choose.getServiceId();
    }

}
