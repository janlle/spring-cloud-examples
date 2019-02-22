package com.andy.order.item.controller;

import com.andy.common.beans.order.item.OrderItemVO;
import com.andy.order.item.service.OrderItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *
 * @author Leone
 * @since 2018-03-10
 **/
@Slf4j
@RestController
@RequestMapping("/orderItem")
public class OrderItemController {

    @Resource
    private OrderItemService orderItemService;

    @GetMapping("/{orderId}")
    public List<OrderItemVO> list(@RequestHeader HttpHeaders headers, @PathVariable Long orderId) {
        return orderItemService.findByOrderId(orderId);
    }

    @GetMapping
    public OrderItemVO findOne(@RequestParam("orderId") Long orderId, @RequestHeader HttpHeaders headers) {
        return orderItemService.findOne(orderId);
    }

    @DeleteMapping
    public void delete(@RequestParam("orderId") Long orderId) {
        orderItemService.delete(orderId);
    }


}
