package com.leone.cloud.order.item;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

/**
 * <p> 消费者 下游服务
 *
 * @author Leone
 * @since 2018-03-10
 **/
@SpringCloudApplication
public class OrderItemApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderItemApplication.class, args);
    }
}
