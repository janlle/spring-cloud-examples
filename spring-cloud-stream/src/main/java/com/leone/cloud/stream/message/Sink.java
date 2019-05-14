package com.leone.cloud.stream.message;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;


/**
 * <p> input 通道接口
 *
 * @author leone
 * @since 2019-01-28
 **/
public interface Sink {

    String INPUT1 = "input1";
    String INPUT2 = "input2";


    @Input(Sink.INPUT1)
    SubscribableChannel input1();

    @Input(Sink.INPUT2)
    SubscribableChannel input2();


}