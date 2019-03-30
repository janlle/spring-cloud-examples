package com.andy.feign.client;

import com.andy.common.beans.user.UserAddVO;
import com.andy.common.beans.user.UserEditVO;
import com.andy.common.beans.user.UserVO;
import com.andy.common.entity.User;
import com.andy.feign.config.FeignConfiguration1;
import feign.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

/**
 * @author Leone
 * @since 2018-03-13
 **/
@FeignClient(value = "mc-user"/*, url = "http://127.0.0.1/user"*/, configuration = FeignConfiguration1.class)
public interface UserFeignClient {

    @RequestLine("GET /user/{id}")
    User find(@Param("id") Long id, @HeaderMap Map<String, String> header);

    @RequestLine("GET /user/list")
    @Headers("name-Type: default")
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
