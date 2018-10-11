package com.andy.hystrix.config;

import com.andy.hystrix.entity.User;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <p>
 *
 * @author Leone
 * @since 2018-02-13
 **/
@Slf4j
@Component
public class HystrixClientFallbackFactory implements FallbackFactory<UserFeignClient1> {

    @Override
    public UserFeignClient1 create(Throwable cause) {
        return new UserFeignClient1() {
            @Override
            public User user(Integer userId) {
                log.info("进入fallback方法");
                return new User(12, new Date(), "james", "password", "15687793324");
            }

            @Override
            public List<User> list() {
                log.info("进入fallback方法");
                return new ArrayList<>();
            }
        };
    }
}
