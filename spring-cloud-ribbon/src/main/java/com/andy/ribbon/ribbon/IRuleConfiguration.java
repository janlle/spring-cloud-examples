package com.andy.ribbon.ribbon;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;

@Slf4j
@Configuration
@ExcludeFromComponentScan
public class IRuleConfiguration {
	
//	@Autowired
//	private IClientConfig clientConfig;
	
	@Bean
	public IRule ribbonRule(){
		log.info("ribbonRule->随机");
		return new RandomRule();
	}
	
	
}