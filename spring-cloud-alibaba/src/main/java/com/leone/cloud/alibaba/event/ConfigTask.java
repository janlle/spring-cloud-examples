package com.leone.cloud.alibaba.event;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * <p>
 *
 * @author leone
 * @since 2024-11-21
 **/
@RefreshScope
@Configuration
@EnableScheduling
public class ConfigTask {

    //@NacosValue(value = "${alibaba.name}", autoRefreshed = true)
    @Value(value = "${alibaba.name}")
    private String alibabaName;

    @Value(value = "${spring.application.name}")
    private String appName;

    @Scheduled(fixedDelay = 10 * 1000)
    private void test() {
        System.out.println(alibabaName == null ? "None" : alibabaName);
    }


}