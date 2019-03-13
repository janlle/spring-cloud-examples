package com.andy.hystrix.function;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandProperties;

import java.util.concurrent.TimeUnit;

/**
 * <p> 重载HystrixCommand 的getFallback方法实现逻辑
 *
 * @author leone
 * @since 2019-03-13
 **/
public class TimeOutCommandTest extends HystrixCommand<String> {

    private final String name;

    public TimeOutCommandTest(String name) {
        super(HystrixCommand.Setter.withGroupKey(
                HystrixCommandGroupKey.Factory.asKey("HelloWorldGroup"))
                // 配置依赖超时时间,500毫秒
                .andCommandPropertiesDefaults(HystrixCommandProperties.Setter().
                        withExecutionIsolationThreadTimeoutInMilliseconds(500)));
        this.name = name;
    }

    @Override
    protected String getFallback() {
        return "executor failed fallback";
    }

    @Override
    protected String run() throws Exception {
        // sleep 600毫秒，调用会超时
        TimeUnit.MILLISECONDS.sleep(600);
        return "name: " + name + " thread name: " + Thread.currentThread().getName();
    }

    public static void main(String[] args) throws Exception {
        TimeOutCommandTest command = new TimeOutCommandTest("test-Fallback");
        String result = command.execute();
        System.out.println(result);
    }

}  