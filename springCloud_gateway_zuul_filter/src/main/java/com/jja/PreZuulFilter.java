package com.jja;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.ZuulFilterResult;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: Mr.ruolin
 * @createBy: 2018-02-07 09:22
 **/
public class PreZuulFilter extends ZuulFilter {

    public static final Logger logger = LoggerFactory.getLogger(ZuulFilter.class);

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
        String name = (String)request.getParameter("name");
        System.out.println(name);
        String host = (String)request.getRemoteHost();
        logger.info("请求的host为:"+host);
        return null;
    }
}
