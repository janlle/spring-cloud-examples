package com.leone.cloud.order.config;

import com.leone.cloud.order.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class HttpClientConfig {

    @Bean
    RestClient.Builder restClientBuilder() {
        return RestClient.builder();
    }

    @Bean
    public UserService helloClient(RestClient.Builder restClientBuilder) {
        return HttpServiceProxyFactory
          .builder()
          .exchangeAdapter(
            RestClientAdapter.create(
              restClientBuilder.baseUrl("http://localhost:8001").build()
            )
          )
          .build().createClient(UserService.class);
    }

}
