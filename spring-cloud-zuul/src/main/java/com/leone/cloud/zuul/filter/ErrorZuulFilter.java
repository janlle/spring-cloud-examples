package com.leone.cloud.zuul.filter;

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
public class ErrorZuulFilter extends ZuulFilter {

    private static final Logger log = LoggerFactory.getLogger(PostZuulFilter.class);


    /**
     * 异常过滤器
     * @return
     */
    @Override
    public String filterType() {
        return FilterConstants.ERROR_TYPE;
    }

    @Override
    public int filterOrder() {
        // 优先级，数字越大，优先级越低
        return FilterConstants.SEND_ERROR_FILTER_ORDER;
    }

    /**
     * 是否执行该过滤器，true 代表需要执行
     *
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 主要的处理逻辑的地方，我们做权限控制、日志等都是在这里
     *
     * @return
     */
    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        ctx.setResponseBody("出现异常");
        log.info("error filter run:{}", ctx.getResponseBody());
        return null;
    }
}