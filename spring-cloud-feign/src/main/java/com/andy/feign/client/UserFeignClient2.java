package com.andy.feign.client;

import com.andy.feign.entity.User;
import com.andy.feign.config.ConfigurationFeign1;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author Leone
 * @since 2017-11-13
 **/
@FeignClient(name = "spring-cloud-provider", configuration = ConfigurationFeign1.class)
public interface UserFeignClient2 {

    @RequestLine("GET /user/{userId}")
    User user(@Param("userId") int userId);

    @RequestLine("POST /user")
    User user(User users);

}
