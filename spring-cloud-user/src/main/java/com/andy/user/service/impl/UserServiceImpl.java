package com.andy.user.service.impl;


import com.andy.common.beans.user.UserEditVO;
import com.andy.common.beans.user.UserVO;
import com.andy.common.entity.User;
import com.andy.common.utils.EntityFactory;
import com.andy.user.service.UserService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
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

    @Override
    public Integer delete(Long userId) {
        EntityFactory.remove(userId);
        return 1;
    }

    @Override
    public UserVO update(UserEditVO editVO) {
        User user = EntityFactory.getUser(editVO.getUserId());
        BeanUtils.copyProperties(editVO, user);
        UserVO vo = new UserVO();
        BeanUtils.copyProperties(user, vo);
        return vo;
    }

    @Override
    public UserVO save(UserVO user) {
        return user;
    }

    @HystrixCommand(fallbackMethod = "findOneFallback")
    @Override
    public UserVO findOne(Long userId) {
        if (random.nextBoolean()) {
            int i = 10 / 0;
        }
        User user = EntityFactory.getUser(userId);
        UserVO vo = new UserVO();
        BeanUtils.copyProperties(user, vo);
        return vo;
    }


    public UserVO findOneFallback(Long userId) {
        log.error("findOneFallback userId: ", userId);
        return new UserVO();
    }

    @Override
    public List<UserVO> list() {
        return EntityFactory.getUsers(10).stream().map(e -> {
                    UserVO vo = new UserVO();
                    BeanUtils.copyProperties(e, vo);
                    return vo;
                }
        ).collect(Collectors.toList());
    }
}
