package com.jja;

import com.jja.feign.FeignClient2;

public class HystrixClientFallback2 implements FeignClient2 {

	@Override
	public String findEurekaServiceByName(String serviceName) {
		return "haha";
	}

}
