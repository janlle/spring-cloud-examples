package com.andy.feign.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.Date;

/**
 * @author Leone
 * @since 2018-02-13
 **/
@Data
@ApiModel
public class User {

    private Integer userId;

    private Date birthday;

    private String username;

    private String password;

    private String phone;

    public User() {
    }

    public User(Integer userId, Date birthday, String username, String password, String phone) {
        this.userId = userId;
        this.birthday = birthday;
        this.username = username;
        this.password = password;
        this.phone = phone;
    }
}

