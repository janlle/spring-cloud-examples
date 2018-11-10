package com.andy.feign.controller;

import com.andy.feign.client.UserFeignClient;
import com.andy.feign.entity.User;
import com.andy.feign.pojo.UserAddVO;
import com.andy.feign.pojo.UserEditVO;
import com.andy.feign.pojo.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Leone
 * @since 2017-10-22
 **/
@Slf4j
@RestController
@RequestMapping("/feign")
public class FeignController {

    @Autowired
    private UserFeignClient userFeignClient;

//    @Autowired
//    private UserFeignClient1 userFeignClient1;
//
//    @Autowired
//    private UserFeignClient2 userFeignClient2;

    @GetMapping(value = "/user/list", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<User> list() {
        return userFeignClient.list();
    }

    @GetMapping("/user/{id}")
    public User user(@PathVariable("id") Long id) {
        Map<String, String> headers = new HashMap<>();
        headers.put("a", "aaa");
        headers.put("b", "bbb");
        headers.put("c", "ccc");
        return userFeignClient.find(id, headers);
    }

    @PutMapping("/user")
    public UserVO update(@RequestBody UserEditVO user) {
        return userFeignClient.update(user);
    }

    @PostMapping("/user")
    public UserVO save(@RequestBody UserAddVO user) {
        return userFeignClient.save(user);
    }

    @DeleteMapping("/user")
    public void delete(@RequestParam("userId") Long userId) {
        log.info("user feign delete");
        Map<String, Long> param = new HashMap<>();
        param.put("userId", userId);
        userFeignClient.delete(param);
    }

    @PostMapping("/user/upload")
    public String upload(MultipartFile file) {
        return userFeignClient.upload(file);
    }

//    @GetMapping("/{serviceName}")
//    public String findEurekaServiceByName(@PathVariable("serviceName") String serviceName) {
//        return userFeignClient1.findEurekaServiceByName(serviceName);
//    }

}
