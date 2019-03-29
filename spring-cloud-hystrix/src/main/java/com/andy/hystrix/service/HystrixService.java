package com.andy.hystrix.service;

import com.andy.common.entity.User;
import com.andy.common.utils.EntityFactory;
import org.springframework.stereotype.Service;

/**
 * <p>
 *
 * @author leone
 * @since 2019-03-29
 **/
@Service
public class HystrixService {


    public User find(Long userId) {
        return new User();
    }

    public User simpleFallback(Long userId) {
        return EntityFactory.getUser(1L);
    }

}
