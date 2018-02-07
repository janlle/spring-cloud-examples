package com.jja.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ConfigClientController {

    @Value("${profile}")
    private String profile;

    @Value("${sql}")
    private String sql;

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String  getProfile() {
        return profile;
    }

    @GetMapping("/env")
    public Map<String, String> env() {
        Map<String ,String > map = new HashMap<>();
        map.put("profile", profile);
        map.put("sql", sql);
        return map;
    }


}
