package com.leone.cloud.order.service;

import com.leone.cloud.common.entity.User;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;

import java.util.List;

public interface UserService {

    @GetExchange("/user-def")
    User findOne(@RequestParam("userId")Long userId);

    List<User> list();

}
