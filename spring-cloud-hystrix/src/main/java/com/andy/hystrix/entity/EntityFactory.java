package com.andy.hystrix.entity;

import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * <p>
 *
 * @author Leone
 * @since 2018-01-10
 **/
@Slf4j
public class EntityFactory {

    private Random random = new Random();

    private static Map<Long, User> userMap = new HashMap<>();

    static {
        for (long i = 0; i < 100; i++) {
            userMap.put(i, new User(i, "jack", getNum(12), "hello " + getNum(6), 18, new Date(), false));
        }
    }

    public static final String JSON_USER = "{\"username\":\"james\",\"password\":\"admin\",\"email\":\"andy@163.com\",\"token\":\"token:12idkail8lld\",\"salary\":10004,\"birthday\":\"2018-04-02\"}";

    /**
     * 获取object数据格式数据
     *
     * @param count
     * @return
     */
    public static List<User> getUsers(Integer count) {
        List<User> userList = new ArrayList<>();
        if (count < 1) {
            return null;
        }
        for (long i = 0; i < count; i++) {
            userList.add(new User(i, "jack", getNum(12), "hello " + getNum(6), 18, new Date(), false));
        }
        return userList;
    }

    public static User getUser() {
        return new User(Long.valueOf(getNum(6)), "andy", getNum(12), "hello my friend i am a boy " + getNum(6), 18, new Date(), false);
    }

    public static User getUser(Long userId) {
        return userMap.get(userId);
    }

    private static String getNum(Integer length) {
        if (length < 1 || length > 512) {
            length = 32;
        }
        StringBuilder result = new StringBuilder();
        final String sources = "0123456789";
        Random rand = new Random();
        for (int i = 0; i < length; i++) {
            result.append(sources.charAt(rand.nextInt(9)));
        }
        return result.toString();
    }
}