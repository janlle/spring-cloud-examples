package com.leone.hystrix.function;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandProperties;

import java.util.Random;

/**
 * <p> 资源隔离：信号量隔离
 *
 * @author leone
 * @since 2019-03-29
 **/
public class SemaphoreCommandTest extends HystrixCommand<String> {

    private int time = new Random().nextInt(1500);

    private final int id;

    public SemaphoreCommandTest(int id) {
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("SemaphoreGroup"))
                // 使用信号量来隔离资源只允许一定的线程执行业务代码默认 10 个
                .andCommandPropertiesDefaults(HystrixCommandProperties.Setter()
                        .withExecutionIsolationStrategy(HystrixCommandProperties.ExecutionIsolationStrategy.SEMAPHORE)
                        // 设置超时时间
                        .withExecutionTimeoutInMilliseconds(900)
                        // 设置信号量隔离时的最大并发请求
                        .withExecutionIsolationSemaphoreMaxConcurrentRequests(5)
                        // 设置fallback的最大并发数（默认 10 个）
                        .withFallbackIsolationSemaphoreMaxConcurrentRequests(20)));
        this.id = id;
    }

    @Override
    protected String run() throws InterruptedException {
        // 当业务调用线程操作信号量的最大数量后就会走降级（fallback）方法
        Thread.sleep(time);
        return "id: " + id + " time: " + time;
    }

    @Override
    protected String getFallback() {
        return "id: 1 time: " + time;
    }

    static class UnitTest {
        public static void main(String[] args) {
            for (int i = 0; i < 25; i++) {
                SemaphoreCommandTest command = new SemaphoreCommandTest(2000);
                new Thread(() -> {
                    String execute = null;
                    try {
                        execute = command.queue().get();
                        // execute = command.execute();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    if (execute.startsWith("id: 1")) {
                        System.err.println(Thread.currentThread().getName() + "\t\t" + execute);
                    } else {
                        System.out.println(Thread.currentThread().getName() + "\t\t" + execute);
                    }
                }).start();
            }
        }
    }

}


