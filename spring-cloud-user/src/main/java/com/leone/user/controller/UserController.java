package com.leone.user.controller;

import com.leone.common.beans.user.UserEditVO;
import com.leone.common.beans.user.UserVO;
import com.leone.user.service.UserService;
import com.netflix.discovery.EurekaClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;


/**
 * <p>
 *
 * @author Leone
 * @since 2018-03-10
 **/
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private EurekaClient eurekaClient;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private UserService userService;

    @Value("${server.port}")
    private String port;

//    @GetMapping("/instance")
//    public String serviceUrl() {
//        InstanceInfo instance = eurekaClient.getNextServerFromEureka("USER-SERVICE", false);
//        return instance.getHomePageUrl();
//    }

    @GetMapping("/info")
    public List<String> serviceInfo() {
        log.info("user service port: {}", port);
        return discoveryClient.getServices();
    }

    @GetMapping("/list")
    public List<UserVO> list(@RequestHeader HttpHeaders headers) {
        log.info("request header:{}", headers.get("name-Type"));
        log.info("request header:{}", headers.get("User-Agent"));
        log.info("request header:{}", headers.get("Accept"));
        headers.getAccessControlAllowHeaders().forEach(System.out::println);
        log.info("user service list port: {}", port);
        return userService.list();
    }

    @GetMapping("/{userId}")
    public UserVO findOne(@PathVariable("userId") Long userId, @RequestHeader HttpHeaders headers) {
        //log.info("request header:{}", headers.get("name-Type"));
        //log.info("request header:{}", headers.get("a"));
        //log.info("request header:{}", headers.get("b"));
        //log.info("request header:{}", headers.get("c"));
        log.info("user service findOne port: {}", port);
        return userService.findOne(userId);
    }

    @DeleteMapping
    public void delete(@RequestParam("userId") Long userId) {
        log.info("user service delete port: {}", port);
        userService.delete(userId);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public UserVO update(@RequestBody UserEditVO user) {
        log.info("user service update port: {}", port);
        return userService.update(user);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public UserVO save(@RequestBody UserVO user) {
        log.info("user service save: {}", port);
        return userService.save(user);
    }


    /**
     * 上传文件
     * 有界面的测试：http://localhost:9001/index.html
     * 使用命令：curl -F "file=@文件全名" localhost:9001/user/upload
     *
     * @param file 待上传的文件
     * @return 文件在服务器上的绝对路径
     * @throws IOException IO异常
     */
    @PostMapping("/upload")
    public String upload(MultipartFile file) throws IOException {
        if (null != file) {
            String fileName = file.getOriginalFilename();
            log.info("fileName:{} port: {}", fileName, port);
            InputStream inputStream = file.getInputStream();
            OutputStream outputStream = new FileOutputStream("E:/tmp/upload/" + fileName);
            int len;
            byte[] bytes = new byte[1024];
            while ((len = inputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, len);
            }
            outputStream.close();
            inputStream.close();
            return fileName;
        }
        return "error";
    }

}
