package com.leone.hystrix.function;

import com.netflix.hystrix.*;
import org.junit.Test;

/**
 * <p> 断路器
 *
 * @author leone
 * @since 2019-03-12
 **/
public class CircuitBreakerTest {

    public static int num = 0;

    static HystrixCommand.Setter setter = HystrixCommand.Setter
            .withGroupKey(HystrixCommandGroupKey.Factory.asKey("circuitBreakerTestGroup"))
            .andCommandKey(HystrixCommandKey.Factory.asKey("circuitBreakerTestCommand"))
            .andThreadPoolKey(HystrixThreadPoolKey.Factory.asKey("circuitBreakerTestPool"))
            .andThreadPoolPropertiesDefaults(HystrixThreadPoolProperties.Setter()
                    // 配置线程池
                    .withCoreSize(10))
            .andCommandPropertiesDefaults(HystrixCommandProperties.Setter()
                    .withCircuitBreakerEnabled(true)
                    .withCircuitBreakerRequestVolumeThreshold(10)
                    .withCircuitBreakerErrorThresholdPercentage(80));

    // 未配置的值均取系统默认值
    HystrixCommand<Object> hystrixCommand = new HystrixCommand<Object>(setter) {
        @Override
        protected Object run() throws Exception {
            if (num % 2 == 0) {
                return String.valueOf(num);
            } else {
                int j = 0;
                // 死循环模拟调用超时
                while (true) {
                    j++;
                }
            }
        }

        @Override
        protected Object getFallback() {
            return "CircuitBreaker fallback: " + num;
        }

    };

    @Test
    public void circuitBreakerTest() throws Exception {
        for (int i = 0; i < 30; i++) {
            CircuitBreakerTest.num = i;
            CircuitBreakerTest circuitBreakerTest = new CircuitBreakerTest();
            String result = (String) circuitBreakerTest.hystrixCommand.execute();
            System.out.println(result);
        }
    }

}