package com.leone.cloud.order.controller;

import com.leone.cloud.common.beans.order.OrderVO;
import com.leone.cloud.common.beans.user.UserVO;
import com.leone.cloud.common.entity.Order;
import com.leone.cloud.order.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author Leone
 * @since 2018-06-20
 **/
@Slf4j
@RestController
public class OrderController {

    // @Autowired
    private OrderService orderService;

    // @Autowired
    private RestTemplate restTemplate;

    // @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Value("${server.port}")
    private Integer port;

    @GetMapping("/order")
    public String hello() {
        log.info("hello mc-order {}", port);
        return "hello mc-order " + port;
    }

    @GetMapping(value = "/order/{orderId}")
    public Order findOne(@PathVariable("orderId") Long orderId) {
        Order order = new Order();
        order.setOrderId(orderId);
        order.setTotalAmount(port);
        return order;
    }

    @GetMapping(value = "/order/list")
    public List<OrderVO> list(@RequestParam Long userId) {
        return orderService.list(userId);
    }

    @GetMapping(value = "/order/load", produces = {MediaType.APPLICATION_JSON_VALUE})
    public String loadBalancer() {
        String url = "http://localhost:8001/info";
        String result = restTemplate.getForObject("http://localhost:8001/info", String.class);

        ServiceInstance instance = loadBalancerClient.choose("mc-user");
        log.info("instance->host:{},port:{},serviceId:{},scheme:{},url:{},metadata:{}", instance.getHost(), instance.getPort(), instance.getServiceId(), instance.getScheme(), instance.getUri(), instance.getMetadata());
        UserVO user = restTemplate.getForObject(url, UserVO.class);

        log.info("get: -> {} result: -> {}", url, result);
        return result;
    }


}
