package com.jja;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;

@Configuration
@ExcludeFromComponentScan
public class TestConfiguration {
	
//	@Autowired
//	IClientConfig clientConfig;
	
	@Bean
	public IRule ribbonRule(){
		System.out.println("随机");
		return new RandomRule();
	}
	
	
}