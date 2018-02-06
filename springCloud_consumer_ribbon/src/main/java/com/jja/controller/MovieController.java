package com.jja.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.jja.entity.Users;

@RestController
public class MovieController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private LoadBalancerClient loadBalancerClient;
	
	@GetMapping("/getObj/{id}")
	public Users getObj(@PathVariable("id")int id) {
		System.out.println("访问到了");
		//return restTemplate.getForObject("http://localhost:8001/getUser/"+id, Users.class);
		return restTemplate.getForObject("http://user:password123@springCloud-provider/getUser/"+id, Users.class);
	}
	
	@GetMapping("/test")
	public String test(){
		ServiceInstance choose = loadBalancerClient.choose("springCloud-provider");
		System.out.println("app1:"+choose.getHost()+"=="+choose.getPort()+"=="+choose.getServiceId());

		ServiceInstance choose2 = loadBalancerClient.choose("springCloud-provider2");
		System.out.println("app2:"+choose2.getHost()+"=="+choose2.getPort()+"=="+choose2.getServiceId());
		System.out.println();
		return "success";
	}

	@GetMapping("/movie/{id}")
	public Users movie(@PathVariable("id") Integer id){
		System.out.println("电影微服务！");
		Users user = new Users();
		user.setId(id);
		user.setUsername("movie");
		user.setPassword("moviepassword");
		user.setSalary(13000);
		return user;
	}
	
	
	
}
