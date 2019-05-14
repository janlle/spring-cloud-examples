package com.leone.cloud.stream.message;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.stereotype.Component;

/**
 * <p> output通道接口
 *
 * @author leone
 * @since 2019-01-28
 **/
@Component
public interface Source {

    String OUTPUT1 = "output1";

    String OUTPUT2 = "output2";

    @Input("aa")
    SubscribableChannel input();

    @Output(Source.OUTPUT1)
    MessageChannel output1();

    @Output(Source.OUTPUT2)
    MessageChannel output2();

}