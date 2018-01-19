package com.jja.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.annotation.SessionScope;

import com.jja.entity.Users;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@RestController
//@SessionScope
public class MovieController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/getObj/{id}")
	@HystrixCommand(fallbackMethod = "findByIdFallback", commandProperties=@HystrixProperty(name="execution.isolation.strategy", value="SEMAPHORE"))
	public Users getObj(@PathVariable("id")int id) {
		System.out.println("访问到了");
		return restTemplate.getForObject("http://springCloud-provider/getUser/"+id, Users.class);
	}
	
	public Users findByIdFallback(int id){
		Users user = new Users();
		user.setId(12);
		return user;
	}
	
	
	
}
