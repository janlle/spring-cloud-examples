package com.leone.cloud.gateway.config;

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
        return builder
                .routes()
                .route(r -> r.path("/order/**")
                        .filters(f -> f.addRequestHeader("jack", "hello"))
                        .uri("http://127.0.0.1:9002"))
                .build();
    }

    /**
     * 通过代码的方式配置路由，在浏览器输入http://localhost:9999/about 将跳转到百度首页
     *
     * @param builder
     * @return
     */
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
