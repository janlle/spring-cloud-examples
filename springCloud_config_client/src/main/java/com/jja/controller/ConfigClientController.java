package com.jja.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigClientController {

    @Value("${profile}")
    private String profile;

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String getProfile() {
        return profile;
    }


}
