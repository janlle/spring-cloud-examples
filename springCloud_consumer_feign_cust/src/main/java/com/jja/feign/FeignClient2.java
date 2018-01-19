package com.jja.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.config.ConfigurationFei2;

/**
 * @author ruolin
 * create by 2017年11月19日上午7:58:57
 */
@FeignClient(name="xxx",url="http://localhost:8761/", configuration=ConfigurationFei2.class)
public interface FeignClient2 {
	
	@RequestMapping(value="/eureka/apps/{serviceName}")
	public String findEurekaServiceByName(@PathVariable("serviceName")String serviceName);
}
