package com.leone.cloud.order.function;

import com.netflix.hystrix.*;

import java.util.Random;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * hystrix 资源隔离：线程池隔离
 *
 * @author leone
 * @since 2019-03-12
 **/
public class ThreadPoolCommandTest extends HystrixCommand<String> {

    private final String name;

    private final int time = new Random().nextInt(999);

    /**
     * 在继承hystrixCommand的构造函数中实现添加线程池参数记性资源隔离
     *
     * @param name name
     */
    public ThreadPoolCommandTest(String name) {
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("ExampleGroup"))
          .andCommandKey(HystrixCommandKey.Factory.asKey("ExampleCommand"))
          .andThreadPoolKey(HystrixThreadPoolKey.Factory.asKey("ExampleThreadPool"))
          .andThreadPoolPropertiesDefaults(HystrixThreadPoolProperties.Setter()
            // hystrix核心线程数默认10个
            .withCoreSize(5)
            // 最大排队长度。默认-1
            .withMaxQueueSize(10)
            // 排队线程数量阈值，默认为5，达到时拒绝，如果配置了该选项，队列的大小是该队列 如果maxQueueSize=-1的话，则该选项不起作用
            .withQueueSizeRejectionThreshold(7))
          .andCommandPropertiesDefaults(HystrixCommandProperties.Setter()
            // 打开timeout开关
            .withExecutionTimeoutEnabled(true)
            // 设置超时时间
            .withExecutionTimeoutInMilliseconds(1000)
          )
        );
        this.name = name;
    }

    /**
     * 依赖逻辑封装在run()方法中
     *
     * @return string
     */
    @Override
    protected String run() throws InterruptedException {
        Thread.sleep(time);
        return "run:" + name + "\t\t" + time + "\t\t" + Thread.currentThread().getName();
    }

    /**
     * 失败调用降级方法
     *
     * @return str
     */
    @Override
    protected String getFallback() {
        return "fallback \t\t time: " + time + "\t\t" + Thread.currentThread().getName();
    }


    public static void main(String[] args) throws Exception {
        // 模拟使用2个线程调用业务代码
        for (int i = 0; i < 20; i++) {
            // 每个Command对象不可以重复调用，否则报错:This instance can only be executed once. Please instantiate a new instance.
            ThreadPoolCommandTest command = new ThreadPoolCommandTest("james");
            new Thread(() -> {
                String execute = "";
                try {
                    // 异步调用,可自由控制获取结果时机
                    Future<String> queue = command.queue();
                    // get操作不能超过command定义的超时时间,默认:1秒
                    execute = queue.get(100, TimeUnit.MINUTES);

                    // 使用execute() 同步调用代码,效果等同于:helloWorldCommandTest.queue().get();
                    // execute = command.execute();
                    // execute = command.queue().get();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (execute.startsWith("fallback")) {
                    System.err.println(execute);
                } else {
                    System.out.println(execute);
                }
            }).start();
        }

    }

}
