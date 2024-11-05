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
//@Component
public class PostZuulFilter extends ZuulFilter {

    private static final Logger log = LoggerFactory.getLogger(PostZuulFilter.class);

    /**
     * 后置过滤器
     *
     * @return
     */
    @Override
    public String filterType() {
        return FilterConstants.POST_TYPE;
    }

    /**
     * filter 执行的优先级，数字越大，优先级越低
     *
     * @return
     */
    @Override
    public int filterOrder() {
        return FilterConstants.PRE_DECORATION_FILTER_ORDER + 2;
    }

    /**
     * 是否执行该过滤器，true代表需要过滤
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
        log.info("post filter run... response: {}", ctx.getResponseBody());
        return null;
    }

}
