package com.jja;

import com.jja.entity.Users;

public class HystrixClientFallback implements UserFeignClient {
		@Override
		public Users getUser(int id) {
			Users user = new Users();
			user.setId(0);
			return user;
		}
	}