package com.andy.order.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author Leone
 * @since 2018-2-23 16:50
 **/
@EnableConfigServer
@EnableDiscoveryClient
@SpringBootApplication
public class ConfigServerBusApp {
	public static void main(String[] args) {
		SpringApplication.run(ConfigServerBusApp.class, args);
	}
}
