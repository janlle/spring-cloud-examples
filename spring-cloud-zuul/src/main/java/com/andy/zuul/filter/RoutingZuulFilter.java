package com.andy.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

/**
 * <p>
 *
 * @author leone
 * @since 2019-01-23
 **/
@Component
public class RoutingZuulFilter extends ZuulFilter {

    private static final Logger log = LoggerFactory.getLogger(PostZuulFilter.class);

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
     * filter 执行的优先级，数字越大，优先级越低
     *
     * @return
     */
    @Override
    public int filterOrder() {
        return FilterConstants.RIBBON_ROUTING_FILTER_ORDER;
    }


    /**
     * 主要的处理逻辑的地方，我们做权限控制、日志等都是在这里
     *
     * @return
     */
    @Override
    public Object run() throws ZuulException {
        log.info("routing filter run...");
        return null;
    }


    /**
     * filter 的类型
     *
     * @return
     */
    @Override
    public String filterType() {
        return FilterConstants.ROUTE_TYPE;
    }

}
