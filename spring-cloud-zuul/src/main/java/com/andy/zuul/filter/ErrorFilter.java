package com.andy.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

/**
 * <p>
 *
 * @author Leone
 * @since 2018-02-09
 **/
@Component
public class ErrorFilter extends ZuulFilter {

    private static Logger log = LoggerFactory.getLogger(ErrorFilter.class);

    @Override
    public String filterType() {
        //异常过滤器
        return FilterConstants.ERROR_TYPE;
    }

    @Override
    public int filterOrder() {
        //优先级，数字越大，优先级越低
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        //是否执行该过滤器，true代表需要过滤
        return true;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();

        log.info("进入异常过滤器");

        System.out.println(ctx.getResponseBody());

        ctx.setResponseBody("出现异常");

        return null;

    }
}