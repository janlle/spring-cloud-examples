package com.andy.stream.message;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * @author Leone
 * @since 2018-06-23 12:46
 **/
public interface StreamClient {

    @Input("myMessage")
    SubscribableChannel input();

    @Output("myMessagea")
    MessageChannel output();

}
