package com.andy.feign.client;

import com.andy.feign.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Leone
 * @since 2018-03-13
 **/
@FeignClient("spring-cloud-provider")
public interface UserFeignClient {

//	不支持getMapping和postMapping并且pathVariable的value属性必须填写
//	@RequestMapping(value="/getUser/{id}",method=RequestMethod.GET)
//    User getUser(@PathVariable("id")int id);
//
//	@RequestMapping(value="/postUser",method=RequestMethod.POST)
//	User postUser(@RequestBody User user);

	@RequestMapping(value = "/user/{userId}", method = RequestMethod.GET)
    User user(@PathVariable("userId")Integer userId);

	@RequestMapping(value = "/user", method = RequestMethod.POST)
    User user(@RequestBody User user);

}
