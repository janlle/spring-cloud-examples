package com.andy.order.item.service;

import com.andy.common.beans.order.item.OrderItemVO;
import com.andy.common.entity.OrderItem;
import com.andy.common.utils.EntityFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 *
 * @author leone
 * @since 2019-02-22
 **/
@Service
public class OrderItemService {

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
    public List<OrderItemVO> findByOrderId(Long orderId) {
        return EntityFactory.getOrderItemList(orderId).stream().map(e -> {
            OrderItemVO vo = new OrderItemVO();
            BeanUtils.copyProperties(e, vo);
            return vo;
        }).collect(Collectors.toList());
    }
}
