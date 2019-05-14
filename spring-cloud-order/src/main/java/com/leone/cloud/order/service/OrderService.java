package com.leone.cloud.order.service;

import com.leone.cloud.common.beans.order.OrderVO;
import com.leone.cloud.common.beans.order.item.OrderItemVO;
import com.leone.cloud.common.beans.user.UserVO;
import com.leone.cloud.common.entity.Order;
import com.leone.cloud.common.utils.EntityFactory;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
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

    private String userUrl = "http://localhost:9001/user/";

    private String orderItemUrl = "http://localhost:9003/orderItem/";

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    /**
     * @param orderId
     * @return
     */
    @HystrixCommand(fallbackMethod = "findOneFallback")
    public OrderVO findOne(Long orderId) {
        Order order = EntityFactory.getOrder(orderId);
        String url = userUrl + order.getUserId();
        UserVO user = restTemplate.getForObject(url, UserVO.class);
        log.info("get: -> {} result: -> {}", url, user);
        if (ObjectUtils.isEmpty(user)) {
            return null;
        }
        OrderVO vo = new OrderVO();
        BeanUtils.copyProperties(order, vo);
        vo.setUserAccount(user.getAccount());
        vo.setUserAge(user.getAge());
        vo.setUserDescription(user.getDescription());

        OrderItemVO[] orderItems = restTemplate.getForObject(orderItemUrl + order.getOrderId(), OrderItemVO[].class);
        log.info("get: -> {} result: -> {}", orderItemUrl + order.getOrderId(), orderItems);

        if (Objects.isNull(orderItems)) {
            vo.setOrderItemList(Collections.emptyList());
        } else {
            vo.setOrderItemList(Arrays.asList(orderItems));
        }
        return vo;
    }


    public OrderVO findOneFallback(Long orderId) {
        log.error("findOneFallback orderId: {}", orderId);
        return new OrderVO();
    }

    /**
     * @param userId
     * @return
     */
    public List<OrderVO> list(Long userId) {
        String url = userUrl + userId;
        /*ParameterizedTypeReference<List<User>> typeRef = new ParameterizedTypeReference<List<User>>() {
        };
        List<UserVO> users = restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<UserVO>>() {
        }).getBody();*/

        UserVO user = restTemplate.getForObject(url, UserVO.class);
        log.info("get: -> {} result: -> {}", url, user);
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
