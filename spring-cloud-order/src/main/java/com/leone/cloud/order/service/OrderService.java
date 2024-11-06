package com.leone.cloud.order.service;

import com.leone.cloud.common.entity.Order;
import com.leone.cloud.common.utils.EntityFactory;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * <p>
 *
 * @author leone
 * @since 2019-01-22
 **/
@Slf4j
@Service
public class OrderService {

    /**
     * @param orderId orderId
     * @return order
     */
    @HystrixCommand(fallbackMethod = "findOneFallback")
    public Order findOne(Long orderId) {
        Order order = EntityFactory.getOrder(orderId);
        if (new Random().nextBoolean()) {
            throw new RuntimeException("自定义异常 orderService.findOne");
        }
        return order;
    }

    public Order findOneFallback(Long orderId) {
        //log.error("findOneFallback orderId: {}", orderId);
        return EntityFactory.getDefaultOrder();
    }

    /**
     * @param userId userId
     * @return list
     */
    public List<Order> list(Long userId) {
        /*ParameterizedTypeReference<List<User>> typeRef = new ParameterizedTypeReference<List<User>>() {
        };
        List<UserVO> users = restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<UserVO>>() {
        }).getBody();*/
        return EntityFactory.getOrderList(userId);
    }


}
