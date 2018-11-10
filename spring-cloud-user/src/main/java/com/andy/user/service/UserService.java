package com.andy.user.service;

import com.andy.user.pojo.UserEditVO;
import com.andy.user.pojo.UserVO;

/**
 * <p>
 *
 * @author Leone
 * @since 2018-11-09
 **/
public interface UserService {

    void deleted(Long userId);

    UserVO update(UserEditVO user);

    UserVO save(UserVO user);
}
