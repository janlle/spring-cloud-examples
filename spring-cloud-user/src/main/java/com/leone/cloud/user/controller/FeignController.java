package com.leone.cloud.user.controller;

import com.leone.cloud.common.beans.user.UserAddVO;
import com.leone.cloud.common.beans.user.UserEditVO;
import com.leone.cloud.common.beans.user.UserVO;
import com.leone.cloud.common.entity.Order;
import com.leone.cloud.common.entity.User;
import com.leone.cloud.user.feign.OrderFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Leone
 * @since 2017-10-22
 **/
@RestController
@RequestMapping("/feign")
public class FeignController {

    @Autowired
    private OrderFeignService orderFeignService;

    @GetMapping(value = "/user")
    public List<User> list(@RequestParam(defaultValue = "1L") Long userId) {
        // Map.of("userId", userId)
        List<Order> orders = orderFeignService.list();
        return orders.stream().map(e -> {
            User user = new User();
            user.setUserId(e.getUserId());
            user.setAccount(e.getTotalAmount().toString());
            return user;
        }).collect(Collectors.toList());
    }

    @GetMapping("/user/{id}")
    public Order user(@PathVariable("id") Long id) {
        Map<String, String> headers = new HashMap<>();
        headers.put("a", "aa");
        headers.put("b", "bb");
        return orderFeignService.find(id, headers);
    }


}
