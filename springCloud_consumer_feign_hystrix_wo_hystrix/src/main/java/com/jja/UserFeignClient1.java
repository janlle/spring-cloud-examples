package com.jja;

import com.config.ConfigurationFei1;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jja.entity.Users;

@FeignClient(name = "springCloud-provider",configuration = ConfigurationFei1.class, fallback = HystrixClientFallback1.class)
public interface UserFeignClient1 {
	
	@RequestMapping(value="/getUser/{id}",method=RequestMethod.GET)
	public Users getUser(@PathVariable("id")int id);
	
}


