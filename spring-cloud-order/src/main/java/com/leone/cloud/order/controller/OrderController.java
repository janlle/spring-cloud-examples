package com.leone.cloud.order.controller;

import com.leone.cloud.common.beans.order.OrderVO;
import com.leone.cloud.common.beans.user.UserVO;
import com.leone.cloud.order.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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

    // @Autowired
    private OrderService orderService;

    // @Autowired
    private RestTemplate restTemplate;

    // @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping(value = "/{orderId}", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public OrderVO findOne(@PathVariable("orderId") Long orderId) {
        return orderService.findOne(orderId);
    }

    @GetMapping(value = "/list/{userId}", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public List<OrderVO> list(@PathVariable("userId") Long userId) {
        return orderService.list(userId);
    }

    @GetMapping(value = "/load", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
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
