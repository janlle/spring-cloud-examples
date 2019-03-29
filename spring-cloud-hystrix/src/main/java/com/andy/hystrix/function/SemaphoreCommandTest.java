package com.andy.hystrix.function;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandProperties;

/**
 * <p> 资源隔离：信号量隔离
 *
 * @author leone
 * @since 2019-03-29
 **/
public class SemaphoreCommandTest extends HystrixCommand<String> {

    private final int id;

    public SemaphoreCommandTest(int id) {
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("ExampleGroup"))
                // since we're doing work in the run() method that doesn't involve network traffic
                // and executes very fast with low risk we choose SEMAPHORE isolation
                .andCommandPropertiesDefaults(HystrixCommandProperties.Setter()
                        .withExecutionIsolationStrategy(HystrixCommandProperties.ExecutionIsolationStrategy.SEMAPHORE)));
        this.id = id;
    }

    @Override
    protected String run() {
        // a real implementation would retrieve data from in memory data structure
        // or some other similar non-network involved work
        return "id: " + id;
    }

    static class UnitTest {
        public static void main(String[] args) {
            SemaphoreCommandTest commandTest = new SemaphoreCommandTest(2);
            String id = commandTest.execute();
            System.out.println(id);
        }
    }

}
