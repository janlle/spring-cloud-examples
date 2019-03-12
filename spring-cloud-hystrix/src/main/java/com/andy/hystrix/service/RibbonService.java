package com.andy.hystrix.service;

import com.andy.common.entity.User;
import com.andy.common.utils.EntityFactory;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * <p>
 *
 * @author Leone
 * @since 2018-11-11
 **/
@Service
public class RibbonService {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "simpleFallback")
    public User find(Long userId) {
        return restTemplate.getForObject("http://mc-user/user/" + userId, User.class);
    }


    public User simpleFallback(Long userId) {
        return EntityFactory.getUser(1L);
    }
}