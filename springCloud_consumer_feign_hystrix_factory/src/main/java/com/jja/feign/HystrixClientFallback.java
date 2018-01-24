package com.jja.feign;

import com.jja.entity.Users;
import org.springframework.stereotype.Component;

@Component
public class HystrixClientFallback implements UserFeignClient {
		@Override
		public Users getUser(int id) {
			Users user = new Users();
			user.setId(0);
			user.setUsername("默认名称");
			return user;
		}
	}