package com.andy.hystrix.config;

import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *
 * @author Leone
 * @since 2018-02-13
 **/
//@Slf4j
//@Component
//public class HystrixClientFallbackFactory implements FallbackFactory<UserFeignClient> {
//
//    @Override
//    public UserFeignClient create(Throwable cause) {
//        return new UserFeignClient() {
//            @Override
//            public User find(Long id) {
//                return null;
//            }
//
//            @Override
//            public List<User> list() {
//                return null;
//            }
//
//            @Override
//            public UserVO update(UserEditVO user) {
//                return null;
//            }
//
//            @Override
//            public UserVO save(UserAddVO user) {
//                return null;
//            }
//
//            @Override
//            public void delete(Map<String, Long> query) {
//
//            }
//
//            @Override
//            public String upload(MultipartFile file) {
//                return null;
//            }
//        };
//    }
//}
