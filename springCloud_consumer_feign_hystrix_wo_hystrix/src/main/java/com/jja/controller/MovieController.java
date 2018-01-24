package com.jja.controller;

import com.jja.feign.FeignClient2;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.jja.UserFeignClient1;
import com.jja.entity.Users;

@RestController
public class MovieController {
	
	@Autowired
	private UserFeignClient1 userFeignClient1;


	@Autowired
	private FeignClient2 feignClient2;

	
	@RequestMapping(value="/getObj/{id}", method = RequestMethod.GET)
	public Users getObj(@PathVariable("id")int id) {
		Users user = userFeignClient1.getUser(id);
		return user;
	}

	@RequestMapping(value="/eureka/apps/{serviceName}",method = RequestMethod.GET)
	public String findEurekaServiceByName(@PathVariable("serviceName")String serviceName){
		String result = feignClient2.findEurekaServiceByName(serviceName);
		return result;
	}
	
}
