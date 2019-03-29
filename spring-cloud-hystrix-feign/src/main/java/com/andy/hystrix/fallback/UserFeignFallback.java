package com.andy.hystrix.fallback;

import com.andy.common.beans.user.UserAddVO;
import com.andy.common.beans.user.UserEditVO;
import com.andy.common.beans.user.UserVO;
import com.andy.common.entity.User;
import com.andy.hystrix.feign.UserFeign;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *
 * @author leone
 * @since 2019-03-29
 **/
public class UserFeignFallback implements UserFeign {

    @Override
    public User find(Long id) {
        return null;
    }

    @Override
    public List<User> list() {
        return null;
    }

    @Override
    public UserVO update(UserEditVO user) {
        return null;
    }

    @Override
    public UserVO save(UserAddVO user) {
        return null;
    }

    @Override
    public void delete(Map<String, Long> query) {

    }

    @Override
    public String upload(MultipartFile file) {
        return null;
    }
}
