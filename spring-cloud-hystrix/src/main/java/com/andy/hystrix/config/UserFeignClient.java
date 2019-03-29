package com.andy.hystrix.config;

import com.andy.common.beans.user.UserAddVO;
import com.andy.common.beans.user.UserEditVO;
import com.andy.common.beans.user.UserVO;
import com.andy.common.entity.User;
import feign.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *
 * @author Leone
 * @since 2018-02-16
 **/
@FeignClient(value = "mc-user"/*, url = "http://127.0.0.1/user"*//*, configuration = FeignConfiguration1.class*/)
public interface UserFeignClient {

    @RequestLine("GET /user/{id}")
    User find(@Param("id") Long id);

    @RequestLine("GET /user/list")
    @Headers("name-Type: james")
    List<User> list();

    @RequestLine("PUT /user")
    UserVO update(@RequestBody UserEditVO user);

    @RequestLine("POST /user")
    UserVO save(@RequestBody UserAddVO user);

    @RequestLine("DELETE /user")
    void delete(@QueryMap Map<String, Long> query);

    @RequestLine("POST /user/upload")
    String upload(MultipartFile file);

}


