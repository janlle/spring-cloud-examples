package com.andy.order.config.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Leone
 * @since 2018-1-23
 **/
@Slf4j
@RefreshScope
@RestController
public class ConfigController {

    @Value("${profile}")
    private String profile;

    @Value("${name}")
    private String name;

    @Value("${level}")
    private String level;

    @GetMapping("/env")
    public Map<String, String> env() {
        Map<String, String> map = new HashMap<>();
        map.put("profile", profile);
        map.put("name", name);
        map.put("level", level);
        return map;
    }


}
