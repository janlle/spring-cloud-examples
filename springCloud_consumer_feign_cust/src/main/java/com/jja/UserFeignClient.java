package com.jja;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.config.ConfigurationFei;
import com.jja.entity.Users;

import feign.Param;
import feign.RequestLine;

@FeignClient(name = "springCloud-provider", configuration = ConfigurationFei.class)
public interface UserFeignClient {
	
	@RequestLine("GET /getUser/{id}")
	public Users getUser(@Param("id")int id);
	
	
}
