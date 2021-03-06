package com.leone.cloud.config.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Leone
 * @since 2018-01-23
 **/
@RefreshScope
@RestController
public class ConfigController {

    @Value("${profile}")
    private String profile;

    @Value("${name}")
    private String name;

    @Value("${filename}")
    private String filename;

    @Value("${level}")
    private String level;

    @GetMapping("/env")
    public Map<String, String> env() {
        Map<String, String> map = new HashMap<>();
        map.put("profile", profile);
        map.put("level", level);
        map.put("filename", filename);
        map.put("name", name);
        return map;
    }


}
