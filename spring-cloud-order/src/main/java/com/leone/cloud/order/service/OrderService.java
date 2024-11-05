package com.leone.cloud.order.service;

import com.leone.cloud.common.beans.order.OrderVO;
import com.leone.cloud.common.beans.order.item.OrderItemVO;
import com.leone.cloud.common.beans.user.UserVO;
import com.leone.cloud.common.entity.Order;
import com.leone.cloud.common.entity.User;
import com.leone.cloud.common.utils.EntityFactory;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;

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
    public List<OrderVO> list(Long userId) {
        /*ParameterizedTypeReference<List<User>> typeRef = new ParameterizedTypeReference<List<User>>() {
        };
        List<UserVO> users = restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<UserVO>>() {
        }).getBody();*/
        User user = EntityFactory.getDefaultUser();
        if (ObjectUtils.isEmpty(user)) {
            return null;
        }
        List<Order> orders = EntityFactory.getOrderList(userId);
        return orders.stream().map(e -> {
            OrderVO vo = new OrderVO();
            BeanUtils.copyProperties(e, vo);
            vo.setUserAccount(user.getAccount());
            vo.setUserAge(user.getAge());
            vo.setUserDescription(user.getDescription());
            return vo;
        }).collect(Collectors.toList());
    }


}
