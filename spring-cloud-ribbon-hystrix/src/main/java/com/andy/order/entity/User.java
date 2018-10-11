package com.andy.order.entity;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

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

