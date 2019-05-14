package com.leone.cloud.hystrix.fallback;

import com.leone.cloud.common.beans.user.UserAddVO;
import com.leone.cloud.common.beans.user.UserEditVO;
import com.leone.cloud.common.beans.user.UserVO;
import com.leone.cloud.common.entity.User;
import com.leone.cloud.hystrix.feign.UserFeign;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *
 * @author leone
 * @since 2018-02-13
 **/
@Slf4j
@Component
public class UserFeignFallbackFactory implements FallbackFactory<UserFeign> {

    @Override
    public UserFeign create(Throwable throwable) {
        return new UserFeign() {
            @Override
            public User find(Long id) {
                log.info("UserFeignFallback: {} find", id);
                return new User(100L, "defaultFactory", "123456", "good man", 28, new Date(), false);
            }

            @Override
            public List<User> list() {
                log.info("UserFeignFallback list");
                return Collections.singletonList(new User(100L, "defaultFactory", "123456", "good man", 28, new Date(), false));
            }

            @Override
            public UserVO update(UserEditVO user) {
                log.info("UserFeignFallback update");
                return new UserVO();
            }

            @Override
            public UserVO save(UserAddVO user) {
                log.info("UserFeignFallback save");
                return new UserVO();
            }

            @Override
            public void delete(Map<String, Long> query) {
                log.info("UserFeignFallback delete");
            }

            @Override
            public String upload(MultipartFile file) {
                log.info("UserFeignFallback");
                return "fallback";
            }
        };
    }
}
