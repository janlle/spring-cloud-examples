package com.leone.cloud.user.service;

import com.leone.cloud.common.entity.User;

import java.util.List;

/**
 * <p>
 *
 * @author Leone
 * @since 2018-11-09
 **/
public interface UserService {

    User findOne(Long userId);

    List<User> list();
}
