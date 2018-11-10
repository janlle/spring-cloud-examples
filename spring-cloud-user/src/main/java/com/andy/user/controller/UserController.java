package com.andy.user.controller;

import com.andy.user.entity.EntityFactory;
import com.andy.user.entity.User;
import com.andy.user.pojo.UserEditVO;
import com.andy.user.pojo.UserVO;
import com.andy.user.service.UserService;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
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
@Api(tags = "用户模块")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private EurekaClient eurekaClient;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private UserService userService;

//    @ApiOperation("详情")
//    @GetMapping("/instance")
//    public String serviceUrl() {
//        InstanceInfo instance = eurekaClient.getNextServerFromEureka("USER-SERVICE", false);
//        return instance.getHomePageUrl();
//    }

    @ApiOperation("info")
    @GetMapping("/info")
    public List<String> serviceInfo() {
        log.info("user service-A");
//		log.info("user service-B");
        return discoveryClient.getServices();
    }

    @ApiOperation("列表")
    @GetMapping("/list")
    public List<User> list() {
        log.info("user service list");
        return EntityFactory.getUsers(10);
    }

    @ApiOperation("获取某个")
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public User find(@PathVariable("id") Long id) {
        log.info("user service find");
        return EntityFactory.getUser(id);
    }

    @ApiOperation("删除")
    @DeleteMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void delete(Long userId) {
        log.info("user service delete");
        userService.deleted(userId);
    }

    @ApiOperation("更新")
    @PutMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public UserVO update(@RequestBody UserEditVO user) {
        log.info("user service update");
        return userService.update(user);
    }

    @ApiOperation("保存")
    @PostMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public UserVO save(@RequestBody UserVO user) {
        log.info("user service save");
        return userService.save(user);
    }

    @ApiOperation("文件上传")
    @PostMapping("/upload")
    public String upload(MultipartFile file) throws IOException {
        if (null != file) {
            String fileName = file.getOriginalFilename();
            log.info("fileName:{}", fileName);
            InputStream inputStream = file.getInputStream();
            OutputStream outputStream = new FileOutputStream("d://" + fileName);
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

    /**
     * 上传文件
     * 有界面的测试：http://localhost:8050/index.html
     * 使用命令：curl -F "file=@文件全名" localhost:8050/upload
     * ps.该示例比较简单，没有做IO异常、文件大小、文件非空等处理
     *
     * @param file 待上传的文件
     * @return 文件在服务器上的绝对路径
     * @throws IOException IO异常
     */
    /*@PostMapping("/upload")
    public @ResponseBody
    String handleFileUpload(@RequestParam MultipartFile file) throws IOException {
        byte[] bytes = file.getBytes();
        File fileToSave = new File(Objects.requireNonNull(file.getOriginalFilename()));
        FileCopyUtils.copy(bytes, fileToSave);
        return fileToSave.getAbsolutePath();
    }*/


}
