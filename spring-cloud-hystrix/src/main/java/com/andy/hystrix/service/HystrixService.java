package com.andy.hystrix.service;

import com.andy.common.entity.User;
import com.andy.common.utils.EntityFactory;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * <p>
 *
 * @author leone
 * @since 2019-03-29
 **/
@Service
public class HystrixService {

    private Random random;

    /**
     * @param userId
     * @return
     */
    @HystrixCommand(fallbackMethod = "simpleFallback")
    public User find(Long userId) {
        if (random.nextInt(100) < 10) {
            int i = 1 / 0;
        }
        return new User();
    }

    public User simpleFallback(Long userId) {
        return EntityFactory.getUser(1L);
    }

}
