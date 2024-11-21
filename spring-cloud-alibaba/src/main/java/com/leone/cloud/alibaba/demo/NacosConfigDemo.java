package com.leone.cloud.alibaba.demo;

import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.exception.NacosException;

import java.util.Properties;

public class NacosConfigDemo {
    public static void main(String[] args) {
        try {
            // 设置Nacos服务器地址
            Properties properties = new Properties();
            properties.setProperty("serverAddr", "127.0.0.1:8848");
            properties.setProperty("username", "nacos");
            properties.setProperty("password", "nacos");
            properties.setProperty("namespace", "8578b490-d369-4c39-b45e-ef3788e5b473");

            // 创建ConfigService实例
            ConfigService configService = NacosFactory.createConfigService(properties);

            // 定义配置ID与分组
            String dataId = "cloud-alibaba-test.yaml";
            String group = "common";

            // 读取配置
            String content = configService.getConfig(dataId, group, 5000L);

            // 输出配置内容
            System.out.println("配置内容: \n" + content);
        } catch (NacosException e) {
            e.printStackTrace();
            System.err.println("读取Nacos配置时发生错误");
        }
    }
}