package com.leone;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author Leone
 * @since 2017-11-22
 **/
@RibbonClient(value = "spring-cloud-provider")
@EnableDiscoveryClient
public class RibbonHystrixApplication {

	public static void main(String[] args) {
		SpringApplication.run(RibbonHystrixApplication.class, args);
	}
	
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}
	
}
