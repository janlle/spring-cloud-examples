package com.andy.order.item.hystrix;

import com.netflix.hystrix.HystrixCommand;

import java.util.concurrent.Future;

/**
 * <p>
 *
 * @author leone
 * @since 2019-02-22
 **/
public class OrderItemHystrixCommand extends HystrixCommand<String> {


    protected OrderItemHystrixCommand(Setter setter) {
        super(setter);
    }

    @Override
    protected String run() throws Exception {
        return null;
    }


}
