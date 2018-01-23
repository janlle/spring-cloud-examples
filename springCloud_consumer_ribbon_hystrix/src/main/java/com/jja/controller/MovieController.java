package com.jja.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.jja.entity.Users;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class MovieController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/getObj/{id}")
	@HystrixCommand(fallbackMethod = "findByIdFallback")
	public Users getObj(@PathVariable("id")int id) {
		System.out.println("访问到了");
		return restTemplate.getForObject("http://user:password123@springCloud-provider/getUser/"+id, Users.class);
	}
	
	public Users findByIdFallback(int id){
		Users user = new Users();
		user.setId(12);
		user.setUsername("默认名称");
		return user;
	}
	
	
	
}
