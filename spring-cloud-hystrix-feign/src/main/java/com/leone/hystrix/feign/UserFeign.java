package com.leone.hystrix.feign;

import com.leone.common.beans.user.UserAddVO;
import com.leone.common.beans.user.UserEditVO;
import com.leone.common.beans.user.UserVO;
import com.leone.common.entity.User;
import com.leone.hystrix.fallback.UserFeignFallbackFactory;
import feign.QueryMap;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

/**
 * <p> @FeignClient value 值是上游服务的 spring.application.name
 *
 * @author Leone
 * @since 2018-02-16
 **/
@FeignClient(value = "mc-user", /*url = "http://127.0.0.1/user",*/ /*fallback = UserFeignFallback.class*/fallbackFactory = UserFeignFallbackFactory.class)
public interface UserFeign {

    @GetMapping("/user/{userId}")
    User find(@PathVariable("userId") Long userId);

    @GetMapping("/user/list")
    List<User> list();

    @PutMapping("/user")
    UserVO update(@RequestBody UserEditVO user);

    @PostMapping("/user")
    UserVO save(@RequestBody UserAddVO user);

    @DeleteMapping("/user")
    void delete(@QueryMap Map<String, Long> query);

    @PostMapping("/user/upload")
    String upload(MultipartFile file);

}


