package com.andy.stream.message;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

/**
 * @author Leone
 * @since 2018-06-23 12:57
 **/
@Slf4j
@Component
@EnableBinding(Sink.class)
public class StreamReceiver {

    @StreamListener(Sink.INPUT)
    public void process(Object object) {
        log.info("message:{}", object);
    }

}
