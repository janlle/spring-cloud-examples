package com.jja.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.jja.UserFeignClient1;
import com.jja.entity.Users;

@RestController
public class MovieController {
	
	@Autowired
	private UserFeignClient1 userFeignClient1;
	
	@RequestMapping(value="/getObj/{id}", method = RequestMethod.GET)
	public Users getObj(@PathVariable("id")int id) {
		Users user = userFeignClient1.getUser(id);
		return user;
	}


	
}
