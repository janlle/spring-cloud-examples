package com.leone.cloud.user.service.impl;


import com.leone.cloud.common.beans.user.UserEditVO;
import com.leone.cloud.common.beans.user.UserVO;
import com.leone.cloud.common.entity.User;
import com.leone.cloud.common.utils.EntityFactory;
import com.leone.cloud.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * <p>
 *
 * @author Leone
 * @since 2018-11-09
 **/
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    private Random random = new Random();


    // @HystrixCommand(fallbackMethod = "findOneFallback")
    @Override
    public User findOne(Long userId) {
        if (random.nextInt(100) < 30) {
            int i = 10 / 0;
        }
        return EntityFactory.getUser(userId);
    }


    public UserVO findOneFallback(Long userId) {
        log.error("findOneFallback userId: {}", userId);
        return new UserVO();
    }

    @Override
    public List<User> list() {
        return EntityFactory.getUsers(10);
    }
}
