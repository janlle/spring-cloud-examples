package com.andy.stream.controller;

import com.andy.stream.message.StreamClient;
import com.netflix.discovery.converters.Auto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author Leone
 * @since 2018-06-23 12:59
 **/
@Slf4j
@RestController
public class MessageController {

    @Autowired
    private StreamClient streamClient;

    @GetMapping("/send")
    public void process() {
        String message = "now" + new Date();
        streamClient.output().send(MessageBuilder.withPayload(message).build());
    }


}
