package com.leone.cloud.zookeeper.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *
 * @author Leone
 * @since 2018-10-26
 **/
@RefreshScope
@RestController
public class TestController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @Value("${spring.application.name}")
    private String instanceName;

    @Autowired
    private Environment environment;

    @Value("${name}")
    private String name;

    @GetMapping("/instance")
    public String instance() {
        //获取实例化的注册节点
        List<ServiceInstance> list = discoveryClient.getInstances(instanceName);

        //获取实例化的服务
        StringBuffer sb = new StringBuffer();
        if (list != null && list.size() > 0) {
            sb.append(list.get(0).getUri());
        }

        return "hello world " + sb;
    }

    @GetMapping("/env")
    public String env() {
        String name = environment.getProperty("name");
        return "Hello," + name;
    }

}