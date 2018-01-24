package com.jja.feign;

import com.jja.entity.Users;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class HystrixClientFactory implements FallbackFactory<UserFeignClient> {

    private static final Logger LOGGER = LoggerFactory.getLogger(HystrixClientFactory.class);

    @Override
    public UserFeignClient create(Throwable throwable) {
        LOGGER.info("fallback: resaon was:"+throwable.getMessage());
        return new UserFeignClientWithFactory() {
            @Override
            public Users getUser(int id) {
                Users user = new Users();
                user.setUsername("默认");
                user.setId(-3);
                return user;
            }
        };
    }
}
