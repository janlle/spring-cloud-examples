package com.leone.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <p>
 *
 * @author leone
 * @since 2019-01-23
 **/
@Configuration
public class GatewayConfiguration {


    @Bean
    public RouteLocator serviceRoute(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/order/**").filters(f -> f.addRequestHeader("jack","hello")).uri("http://127.0.0.1:9002")
                .route(e -> e.path("/goods/**").filters(f -> f.addResponseHeader("time","190125")).uri("http://localhost:9003")
                )).build();
    }

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder
                .routes()
                .route(r -> r.path("/about")
                        .filters(f -> f.addRequestHeader("token", "hello"))
                        .uri("http://baidu.com"))
                .build();
    }


}
