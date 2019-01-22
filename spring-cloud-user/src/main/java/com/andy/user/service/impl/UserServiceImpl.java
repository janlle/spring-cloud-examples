package com.andy.user.service.impl;


import com.andy.common.entity.User;
import com.andy.common.utils.EntityFactory;
import com.andy.common.beans.user.UserEditVO;
import com.andy.common.beans.user.UserVO;
import com.andy.user.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 *
 * @author Leone
 * @since 2018-11-09
 **/
@Service
public class UserServiceImpl implements UserService {

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

    @Override
    public UserVO findOne(Long userId) {
        User user = EntityFactory.getUser(userId);
        UserVO vo = new UserVO();
        BeanUtils.copyProperties(user, vo);
        return vo;
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
