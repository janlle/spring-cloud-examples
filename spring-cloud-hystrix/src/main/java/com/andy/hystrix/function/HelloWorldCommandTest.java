package com.andy.hystrix.function;


import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandKey;
import com.netflix.hystrix.HystrixThreadPoolKey;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * <p> hystrix 示例 使用命令模式封装依赖逻辑
 * 运行结果: run()方法在不同的线程下执行
 *
 * @author leone
 * @since 2019-03-12
 **/
public class HelloWorldCommandTest extends HystrixCommand<String> {

    private final String name;

    /**
     * 在继承hystrixCommand的构造函数中实现添加线程池参数记性资源隔离
     *
     * @param name
     */
    public HelloWorldCommandTest(String name) {
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("ExampleGroup"))
                .andCommandKey(HystrixCommandKey.Factory.asKey("ExampleCommand"))
                .andThreadPoolKey(HystrixThreadPoolKey.Factory.asKey("ExampleThreadPool"))
        );
        this.name = name;
    }

    @Override
    protected String run() {
        // 依赖逻辑封装在run()方法中
        return "Hello\tname: " + name + "\tthread name: " + Thread.currentThread().getName();
    }

    //调用实例
    public static void main(String[] args) throws Exception {
        // 每个Command对象不可以重复调用，否则报错:This instance can only be executed once. Please instantiate a new instance.
        HelloWorldCommandTest command = new HelloWorldCommandTest("Synchronous-hystrix");

        // 使用execute()同步调用代码,效果等同于:helloWorldCommandTest.queue().get();
        String result = command.execute();
        System.out.println("result: " + result);

        command = new HelloWorldCommandTest("Asynchronous-hystrix");

        // 异步调用,可自由控制获取结果时机
        Future<String> future = command.queue();

        // get操作不能超过command定义的超时时间,默认:1秒
        result = future.get(100, TimeUnit.MILLISECONDS);

        System.out.println("result: " + result);
        System.out.println("currentThread: " + Thread.currentThread().getName());
    }


}
