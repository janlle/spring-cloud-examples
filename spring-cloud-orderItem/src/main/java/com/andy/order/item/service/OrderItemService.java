package com.andy.order.item.service;

import com.andy.common.beans.order.item.OrderItemVO;
import com.andy.common.entity.OrderItem;
import com.andy.common.utils.EntityFactory;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * <p>
 *
 * @author leone
 * @since 2019-02-22
 **/
@Slf4j
@Service
public class OrderItemService {

    private Random random = new Random();

    /**
     * @param orderId
     * @return
     */
    public OrderItemVO findOne(Long orderId) {
        OrderItem orderItem = EntityFactory.getOrderItem(orderId);
        OrderItemVO vo = new OrderItemVO();
        BeanUtils.copyProperties(orderItem, vo);
        return vo;
    }


    /**
     * @param orderId
     * @return
     */
    @HystrixCommand(fallbackMethod = "findByOrderIdFallback")
    public List<OrderItemVO> findByOrderId(Long orderId) {
        if (random.nextBoolean()) {
            int i = 10 / 0;
        }

        return EntityFactory.getOrderItemList(orderId).stream().map(e -> {
            OrderItemVO vo = new OrderItemVO();
            BeanUtils.copyProperties(e, vo);
            return vo;
        }).collect(Collectors.toList());
    }

    public List<OrderItemVO> findByOrderIdFallback(Long orderId) {
        log.error("findByOrderIdFallback orderId: {}", orderId);
        return Collections.emptyList();
    }

}
