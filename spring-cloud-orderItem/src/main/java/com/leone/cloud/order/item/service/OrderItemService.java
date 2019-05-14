package com.leone.cloud.order.item.service;

import com.leone.cloud.common.beans.order.item.OrderItemVO;
import com.leone.cloud.common.entity.OrderItem;
import com.leone.cloud.common.utils.EntityFactory;
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
    @HystrixCommand(fallbackMethod = "findOneFallback")
    public OrderItemVO findOne(Long orderId) {
        if (random.nextBoolean()) {
            int i = 10 / 0;
        }
        log.info("findOne {}", orderId);
        OrderItem orderItem = EntityFactory.getOrderItem(orderId);
        OrderItemVO vo = new OrderItemVO();
        BeanUtils.copyProperties(orderItem, vo);
        return vo;
    }

    public OrderItemVO findOneFallback(Long orderId) {
        log.error("findOneFallback {}", orderId);
        return new OrderItemVO();
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
        log.info("findByOrderId orderId: {}", orderId);
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


    @HystrixCommand(fallbackMethod = "deleteFallback")
    public void delete(Long orderId) {
        log.info("delete orderId: ", orderId);
        if (random.nextBoolean()) {
            int i = 10 / 0;
        }
    }

    public void deleteFallback(Long orderId) {
        log.error("delete fallback orderId: ", orderId);
    }


}
