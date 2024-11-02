package com.leone.cloud.user.controller;

import com.leone.cloud.common.entity.Order;
import com.leone.cloud.common.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

/**
 * @author Leone
 * @since 2018-12-21
 **/
@RestController
@RequestMapping("/ribbon")
public class RibbonController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping("/{userId}")
    public Map<String, Integer> order(@PathVariable("userId") int userId) {
        Order order = restTemplate.getForObject("http://mc-order/order/" + userId, Order.class);
        return Map.of("user_id", userId, "order_count", order == null ? 0 : order.getTotalAmount());
    }

    @GetMapping("/choose")
    public String choose() {
        ServiceInstance choose = loadBalancerClient.choose("mc-order");
        System.out.println(choose);
        return "host: " + choose.getHost() + " port: " + choose.getPort() + " serviceId: " + choose.getServiceId();
    }

    @GetMapping("/withouteureka")
    public Map<String, Integer> withOutEureka(@RequestParam int userId) {
        ServiceInstance choose = loadBalancerClient.choose("mc-order");
        Order order = restTemplate.getForObject(String.format("http://%s:%s/user/%d", choose.getHost(), choose.getPort(), userId), Order.class);
        return Map.of("user_id", userId, "order_count", order == null ? 0 : order.getTotalAmount());
    }

}
