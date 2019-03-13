package com.andy.hystrix.function;


import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * <p> hystrix 示例 使用命令模式封装依赖逻辑
 * 运行结果: run()方法在不同的线程下执行
 * result = Hello Synchronous-hystrix thread:hystrix-ExampleGroup-1
 * result = Hello Asynchronous-hystrix thread:hystrix-ExampleGroup-2
 * mainThread = main
 *
 * @author leone
 * @since 2019-03-12
 **/
public class HelloWorldCommandTest extends HystrixCommand<String> {

    private final String name;

    public HelloWorldCommandTest(String name) {
        // 最少配置:指定命令组名(CommandGroup)
        super(HystrixCommandGroupKey.Factory.asKey("ExampleGroup"));
        this.name = name;
    }

    @Override
    protected String run() {
        // 依赖逻辑封装在run()方法中
        return "Hello " + name + " thread:" + Thread.currentThread().getName();
    }

    //调用实例
    public static void main(String[] args) throws Exception {
        // 每个Command对象只能调用一次,不可以重复调用,
        // 重复调用对应异常信息:This instance can only be executed once. Please instantiate a new instance.
        HelloWorldCommandTest helloWorldCommandTest = new HelloWorldCommandTest("Synchronous-hystrix");

        // 使用execute()同步调用代码,效果等同于:helloWorldCommandTest.queue().get();
        String result = helloWorldCommandTest.execute();
        System.out.println("result = " + result);
        helloWorldCommandTest = new HelloWorldCommandTest("Asynchronous-hystrix");

        // 异步调用,可自由控制获取结果时机,
        Future<String> future = helloWorldCommandTest.queue();

        // get操作不能超过command定义的超时时间,默认:1秒
        result = future.get(100, TimeUnit.MILLISECONDS);
        System.out.println("result = " + result);
        System.out.println("mainThread = " + Thread.currentThread().getName());
    }


}
