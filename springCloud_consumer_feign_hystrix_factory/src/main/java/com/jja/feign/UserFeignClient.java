package com.jja.feign;

import com.jja.feign.HystrixClientFactory;
import com.jja.feign.HystrixClientFallback;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jja.entity.Users;

@FeignClient(name = "springCloud-provider", /*fallback = HystrixClientFallback.class,*/ fallbackFactory = HystrixClientFactory.class)
public interface UserFeignClient {
	
	@RequestMapping(value="/getUser/{id}",method=RequestMethod.GET)
	public Users getUser(@PathVariable("id")int id);
	
}


