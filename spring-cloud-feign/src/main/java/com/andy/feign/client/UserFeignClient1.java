package com.andy.feign.client;

import com.andy.feign.config.ConfigurationFeign2;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Leone
 * @since 2017-11-19
 **/
@FeignClient(name = "user", url = "http://localhost:8761/", configuration = ConfigurationFeign2.class)
public interface UserFeignClient1 {

    @RequestMapping(value = "/eureka/apps/{serviceName}")
    String findEurekaServiceByName(@PathVariable("serviceName") String serviceName);

}
