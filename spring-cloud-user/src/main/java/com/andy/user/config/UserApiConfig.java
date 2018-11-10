package com.andy.user.config;

import com.google.common.base.Predicates;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

/**
 * @author Leone
 * @since 2018-08-01
 **/
@Configuration
public class UserApiConfig {

    @Value("${swagger.show}")
    private Boolean enable;

    @Bean
    public Docket webApi() {
        Parameter parameter = new ParameterBuilder()
                .name("Authorization")
                .description("token")
                .modelRef(new ModelRef("string"))
                .parameterType("header")
                .required(false)
                .defaultValue("token ")
                .build();
        return new Docket(DocumentationType.SWAGGER_2)
                .enable(enable)
                .apiInfo(apiInfo())
                .groupName("web-API")
                .globalOperationParameters(Collections.singletonList(parameter))
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.andy.user"))
                .paths(Predicates.alwaysTrue())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("用户服务接口文档")
                .description("用户服务接口文档,注意传入的参数!")
                .version("v1.0.0")
                .build();
    }
}
