package com.jja;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jja.entity.Users;

@FeignClient("springCloud-provider")
public interface UserFeignClient {
	
	@RequestMapping(value="/getUser/{id}",method=RequestMethod.GET)
	public Users getUser(@PathVariable("id")int id);
	
	@RequestMapping(value="/getPostUser",method=RequestMethod.POST)
	public Users getPostUser(@RequestBody Users user);
	
}
