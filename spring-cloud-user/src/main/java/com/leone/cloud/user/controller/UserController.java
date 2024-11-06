package com.leone.cloud.user.controller;

import com.leone.cloud.common.entity.User;
import com.leone.cloud.user.service.UserService;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;


/**
 * <p>
 *
 * @author Leone
 * @since 2018-03-10
 **/
@Slf4j
@RestController
public class UserController {

    @Autowired
    private EurekaClient eurekaClient;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private UserService userService;

    @Value("${server.port}")
    private Integer port;

    @GetMapping("/user")
    public Object user(@RequestHeader HttpHeaders headers) {
        log.info("mc-user service port: {} info: {}", port, discoveryClient.getServices());
        log.info("header InstanceId: {}", headers.get("X-InstanceId"));
        //log.info("request header:{}", headers.get("User-Agent"));
        //headers.getAccessControlAllowHeaders().forEach(System.out::println);
        InstanceInfo instance = eurekaClient.getNextServerFromEureka("mc-user", false);
        log.info("instance: {}", instance);
        User user = userService.findOne(1L);
        user.setAge(port);
        return user;
    }

    // @RequestParam(defaultValue = "1", required = false, name = "userId") Long userId
    @GetMapping("/user/list")
    public Object userList() {
        return userService.list();
    }

    /**
     * 上传文件
     * 有界面的测试：<a href="http://localhost:9001/index.html">...</a>
     * 使用命令：curl -F "file=@文件全名" localhost:9001/user/upload
     *
     * @param file 待上传的文件
     * @return 文件在服务器上的绝对路径
     * @throws IOException IO异常
     */
    @PostMapping("/user/upload")
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
