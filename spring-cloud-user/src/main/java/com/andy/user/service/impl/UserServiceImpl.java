package com.andy.user.service.impl;

import com.andy.user.entity.EntityFactory;
import com.andy.user.entity.User;
import com.andy.user.pojo.UserEditVO;
import com.andy.user.pojo.UserVO;
import com.andy.user.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/**
 * <p>
 *
 * @author Leone
 * @since 2018-11-09
 **/
@Service
public class UserServiceImpl implements UserService {

    @Override
    public void deleted(Long userId) {
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


}
