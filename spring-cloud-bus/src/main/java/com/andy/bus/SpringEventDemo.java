package com.andy.bus;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;

/**
 * @author Leone
 * @since 2018-07-30
 **/
public class SpringEventDemo {
    public static void main(String[] args) {

        // 创建 Annotation 驱动的 Spring 应用上下文
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        // 注册到EventConfiguration 到spring容器
        context.register(EventConfiguration.class);
        context.refresh();

        ApplicationEventPublisher publisher = context;
        // 发布事件
        publisher.publishEvent(new MyApplicationEvent("hello world"));

    }

    private static class MyApplicationEvent extends ApplicationEvent {
        public MyApplicationEvent(String source) {
            super(source);
        }
    }

    @Configuration
    public static class EventConfiguration {

        @EventListener
        public void onEvent(MyApplicationEvent event) {
            System.out.println("监听事件" + event);
        }

    }


}
