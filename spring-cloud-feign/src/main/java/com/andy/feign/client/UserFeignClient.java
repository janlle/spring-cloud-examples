package com.andy.feign.client;

import com.andy.feign.entity.User;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @author Leone
 * @since 2018-03-13
 **/
@FeignClient(value = "spring-cloud-user")
public interface UserFeignClient {

//	不支持getMapping和postMapping并且pathVariable的value属性必须填写
//	@RequestMapping(value="/getUser/{id}",method=RequestMethod.GET)
//    User getUser(@PathVariable("id")int id);
//
//	@RequestMapping(value="/postUser",method=RequestMethod.POST)
//	User postUser(@RequestBody User user);

    @RequestLine("GET /user/{id}")
    User user(@Param("id") Integer id);

    @RequestLine("GET /user/list")
    List<User> list();

    @RequestLine("POST /user")
    User user(@RequestBody User user);


}
