package com.andy.feign.config;

import feign.Contract;
import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Leone
 * @since 2017-11-19
 **/
@Configuration
public class ConfigurationFeign1 {

    @Bean
    public Contract feignContract() {
        return new Contract.Default();
    }

    @Bean
    public Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }
}
