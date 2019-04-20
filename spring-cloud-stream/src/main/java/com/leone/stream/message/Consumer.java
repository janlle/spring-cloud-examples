package com.leone.stream.message;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

/**
 * 用来指定一个或多个定义了@Input 或者 @Output注解的接口，实现对消息通道的绑定。Sink接口是默认输入消息通道绑定接口
 *
 * @author Leone
 * @since 2018-06-23
 **/
@Slf4j
@EnableBinding({Sink.class, Source.class})
public class Consumer {

    @StreamListener(Sink.INPUT1)
    public void receive1(Object object) {
        log.info("message:{}", object);
    }

    @StreamListener(Sink.INPUT2)
    public void receive2(Object object) {
        log.info("message:{}", object);
    }


}
