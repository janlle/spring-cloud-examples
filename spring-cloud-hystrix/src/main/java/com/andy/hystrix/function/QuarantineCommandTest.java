package com.andy.hystrix.function;

import com.netflix.hystrix.*;
import org.assertj.core.util.Arrays;
import org.junit.Test;

import java.util.List;
import java.util.concurrent.Future;

/**
 * <p> 资源隔离：线程池隔离
 *
 * @author leone
 * @since 2019-03-13
 **/
public class QuarantineCommandTest extends HystrixCommand<List> {

    private List<Object> list = Arrays.asList(new Object[]{"a", "b", "c", "c", "e", "f", "g"});

    public QuarantineCommandTest(String name) {
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("ThreadPoolTestGroup"))
                .andCommandKey(HystrixCommandKey.Factory.asKey("testCommandKey"))
                .andThreadPoolKey(HystrixThreadPoolKey.Factory.asKey(name))
                .andCommandPropertiesDefaults(
                        HystrixCommandProperties.Setter()
                                .withExecutionTimeoutInMilliseconds(5000)
                )
                .andThreadPoolPropertiesDefaults(
                        HystrixThreadPoolProperties.Setter()
                                // 配置队列大小
                                .withMaxQueueSize(10)
                                // 配置线程池里的线程数
                                .withCoreSize(2)
                )
        );
    }

    @Override
    protected List run() throws Exception {
        return list;
    }

    public static class UnitTest {
        @Test
        public void testGetOrder() {
            new QuarantineCommandTest("hystrix-order").execute();
            Future<List> future = new QuarantineCommandTest("hystrix-order").queue();
        }

    }
}