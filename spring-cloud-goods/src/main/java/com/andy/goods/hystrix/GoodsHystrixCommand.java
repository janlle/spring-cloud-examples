package com.andy.goods.hystrix;

import com.netflix.hystrix.HystrixCommand;

import java.util.concurrent.Future;

/**
 * <p>
 *
 * @author leone
 * @since 2019-02-22
 **/
public class GoodsHystrixCommand extends HystrixCommand<String> {


    protected GoodsHystrixCommand(Setter setter) {
        super(setter);
    }

    @Override
    protected String run() throws Exception {
        return null;
    }


}
