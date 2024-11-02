package com.leone.cloud.user.config;

// import feign.Contract;
// import feign.Logger;
// import feign.auth.BasicAuthRequestInterceptor;
import feign.Contract;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Leone
 * @since 2017-11-13
 **/
@Configuration
public class FeignConfig {

    // @Bean
    // public BasicAuthRequestInterceptor basicAuthRequestInterceptor() {
    //     return new BasicAuthRequestInterceptor("user", "password123");
    // }

    // @Bean
    // public Logger.Level feignLoggerLevel() {
    //     return Logger.Level.FULL;
    // }

    @Bean
    public Contract feignContract() {
        return new Contract.Default();
    }

}
