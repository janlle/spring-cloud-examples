package com.andy.order.service;

import com.andy.common.beans.order.OrderVO;
import com.andy.common.beans.user.UserVO;
import com.andy.common.entity.Order;
import com.andy.common.utils.EntityFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.client.RestTemplate;

import java.util.List;
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

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    /**
     * @param orderId
     * @return
     */
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
        return vo;
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
