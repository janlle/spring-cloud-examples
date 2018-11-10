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
public class PostFilter extends ZuulFilter {

    private static Logger log = LoggerFactory.getLogger(PostFilter.class);

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
     * 优先级，数字越大，优先级越低
     *
     * @return
     */
    @Override
    public int filterOrder() {
        return FilterConstants.PRE_DECORATION_FILTER_ORDER - 3;
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

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        log.info("进入post过滤器");
        System.out.println(ctx.getResponseBody());
        ctx.setResponseBody("post后置数据");
//        int i = 1 / 0;
        return null;
    }

}
