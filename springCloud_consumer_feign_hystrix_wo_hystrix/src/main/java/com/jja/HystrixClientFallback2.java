package com.jja;

import com.jja.feign.FeignClient2;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
@Component
public class HystrixClientFallback2 implements FeignClient2 {

    @Override
	public String findEurekaServiceByName(String serviceName) {
		return "haha";
	}

}
