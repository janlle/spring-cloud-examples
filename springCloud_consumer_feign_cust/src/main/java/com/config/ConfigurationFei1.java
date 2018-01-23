package com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.Contract;
import feign.Logger;

/**
 * @author ruolin create by 2017年11月19日上午7:41:03
 */
@Configuration
public class ConfigurationFei1 {

	@Bean
	public Contract feignContract() {
		return new feign.Contract.Default();
	}
	
	@Bean
    public Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }
}
