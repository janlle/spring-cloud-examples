package com.leone.stream.controller;

import com.leone.stream.message.Source;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author Leone
 * @since 2018-06-23
 **/
@Slf4j
@RestController
public class MessageController {

    @Autowired
    private Source source;

    @GetMapping("/send")
    public void process() {
        String message = "now" + new Date();
        source.output1().send(MessageBuilder.withPayload(message).build());
    }


}
