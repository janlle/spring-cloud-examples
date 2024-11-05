package com.leone.cloud.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;


/**
 * @author Leone
 * @since 2018-02-07
 **/
//@Component
public class PreZuulFilter extends ZuulFilter {

    private static final Logger log = LoggerFactory.getLogger(PostZuulFilter.class);

    /**
     * filter 的类型 前置过滤器
     *
     * @return
     */
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    /**
     * filter 执行的优先级，数字越大，优先级越低
     *
     * @return
     */
    @Override
    public int filterOrder() {
        return FilterConstants.PRE_DECORATION_FILTER_ORDER;
    }

    /**
     * 是否执行该过滤器，true 代表需要执行
     *
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return false;
    }

    /**
     * 主要的处理逻辑的地方，我们做权限控制、日志等都是在这里
     *
     * @return
     */
    @Override
    public Object run() {
        RequestContext requestContext = RequestContext.getCurrentContext();
        //HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
        //String token = request.getParameter("token");
        //String host = request.getRemoteHost();
        //log.info("pre filter run...  token: {} host: {}", token, host);
        //if (StringUtils.isEmpty(token)) {
        //     不响应 request
            //requestContext.setSendZuulResponse(false);
            //requestContext.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
        //}
        return null;
    }

}
