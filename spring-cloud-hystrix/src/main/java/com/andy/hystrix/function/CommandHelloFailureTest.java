package com.andy.hystrix.function;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * <p>fallback 降级机制
 * HystrixCommand的降级方法是getFallback，HystrixObservableCommand接口的降级方法是resumeWithFallback()
 *
 * @author leone
 * @since 2019-03-12
 **/
public class CommandHelloFailureTest extends HystrixCommand<String> {

    private static final Logger logger = LoggerFactory.getLogger(CommandHelloFailureTest.class);

    private final String name;

    public CommandHelloFailureTest(String name) {
        super(HystrixCommandGroupKey.Factory.asKey("ExampleGroup"));
        this.name = name;
    }

    @Override
    protected String run() throws Exception {
        logger.error("run thread " + Thread.currentThread().getName());
        throw new RuntimeException("this command always fails");
    }

    @Override
    protected String getFallback() {
        logger.error("getFallback thread " + Thread.currentThread().getName());
        return "Hello Failure " + name + "!";
    }


    public static class UnitTest {
        @Test
        public void testSynchronous() throws Exception {
            HystrixCommand<String> hystrixCommand = new CommandHelloFailureTest("world");
            String result = hystrixCommand.execute();
            System.out.println(result);
        }
    }

}
