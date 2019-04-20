package com.leone.hystrix.service;

import com.leone.common.entity.User;
import com.leone.common.utils.EntityFactory;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

/**
 * <p>
 *
 * @author Leone
 * @since 2018-11-11
 **/
@Service
public class RibbonService {

    @Autowired
    private Random random;

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "simpleFallback")
    public User find(Long userId) {
        if (random.nextBoolean()) {
            int i = 1 / 0;
        }
        return restTemplate.getForObject("http://mc-user/user/" + userId, User.class);
    }

    public User simpleFallback(Long userId) {
        return EntityFactory.getUser(1L);
    }

}