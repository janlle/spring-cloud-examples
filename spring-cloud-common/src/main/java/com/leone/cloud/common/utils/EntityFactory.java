package com.leone.cloud.common.utils;

import com.leone.cloud.common.entity.Order;
import com.leone.cloud.common.entity.User;

import java.util.*;
import java.util.stream.Collectors;

/**
 * <p>
 *
 * @author leone
 **/
public class EntityFactory {

    private static final Random random = new Random();

    private static final List<User> userList = new LinkedList<>();

    private static final List<Order> orderList = new LinkedList<>();

    static {
        for (long i = 0; i < 9; i++) {
            Date date = new Date(new Date().getTime() - (random.nextInt(100000) + 10000));
            userList.add(new User(i, RandomValue.randomUsername(), RandomValue.randomStr(16), RandomValue.randomMessage(), RandomValue.random.nextInt(50) + 10, date, false));
            orderList.add(new Order(i, i, random.nextInt(1000) + 200, "Chicken and fish", 1 + RandomValue.randomNum(15), date, date, false));
            orderList.add(new Order(100 + i, i, random.nextInt(100) + 200, "some apple and orange", 1 + RandomValue.randomNum(15), date, date, false));
        }
    }

    /**
     * 获取object数据格式数据
     *
     * @param count count
     * @return list
     */
    public static List<User> getUsers(Integer count) {
        List<User> userList = new ArrayList<>();
        for (long i = 0; i < count; i++) {
            userList.add(new User(i, RandomValue.randomUsername(), RandomValue.randomStr(16), RandomValue.randomMessage(), RandomValue.random.nextInt(50) + 10, new Date(), false));
        }
        return userList;
    }

    /**
     * @return user
     */
    public static Order getDefaultOrder() {
        return new Order(0L, 0L, 100, "Chicken and fish", "T109100", new Date(), new Date(), false);
    }

    /**
     * @return user
     */
    public static User getDefaultUser() {
        return new User(0L, "James", "12345", "hello james", 18, new Date(), false);
    }

    /**
     * @param userId user
     * @return user
     */
    public static User getUser(Long userId) {
        return userList.stream().filter(e -> e.getUserId().equals(userId)).collect(Collectors.toList()).get(0);
    }

    /**
     * @param userId userId
     */
    public static void remove(Long userId) {
        userList.removeIf(next -> next.getUserId().equals(userId));
    }


    /**
     * @param userId user
     * @return list
     */
    public static List<Order> getOrderList(Long userId) {
        return orderList.stream().filter(e -> e.getUserId().equals(userId)).collect(Collectors.toList());
    }


    /**
     * @param orderId orderId
     * @return order
     */
    public static Order getOrder(Long orderId) {
        try {
            Thread.sleep(99);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return orderList.stream().filter(e -> e.getUserId().equals(orderId)).collect(Collectors.toList()).get(0);
    }


}