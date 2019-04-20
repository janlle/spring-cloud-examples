package com.leone.user.service;

import com.leone.common.beans.user.UserEditVO;
import com.leone.common.beans.user.UserVO;

import java.util.List;

/**
 * <p>
 *
 * @author Leone
 * @since 2018-11-09
 **/
public interface UserService {

    Integer delete(Long userId);

    UserVO update(UserEditVO user);

    UserVO save(UserVO user);

    UserVO findOne(Long userId);

    List<UserVO> list();
}
