package com.leone.cloud.alibaba.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * <p>
 *
 * @author leone
 * @since 2024-11-21
 **/
@Slf4j
@RefreshScope
@Configuration
@EnableScheduling
public class ConfigTask {

    @Value(value = "${alibaba.name}")
    private String alibabaName;

    @Value("${count}")
    private Integer count;

    @Value(value = "${spring.application.name}")
    private String appName;

    @Value(value = "${defaultVal}")
    private String defaultVal;

    @Value(value = "${service}")
    private String service;

    @Value(value = "${test}")
    private String testVal;

    @Scheduled(fixedDelay = 100 * 1000)
    private void config1() {
        System.out.println(alibabaName == null ? "None" : alibabaName);
        System.out.println(count);
    }

    @Scheduled(fixedDelay = 10 * 1000)
    private void config2() {
        log.info("defaultVal: {} service: {} testVal: {}",
          defaultVal, service, testVal);
    }


}