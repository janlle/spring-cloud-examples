package com.leone.cloud.user.feign;

import com.leone.cloud.common.entity.Order;
import com.leone.cloud.user.config.FeignConfig;
import feign.HeaderMap;
import feign.Headers;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;

/**
 * @author Leone
 * @since 2018-03-13
 **/
@FeignClient(value = "mc-order", configuration = FeignConfig.class)
public interface OrderFeignService {

    @RequestLine("GET /order/{id}")
    Order find(@Param("id") Long id, @HeaderMap Map<String, String> header);

    @RequestLine("GET /order/list")
    @Headers("name-Type: default")
    // List<Order> list(@QueryMap Map<String, Long> query);
    List<Order> list();

    @RequestLine("POST /order")
    Order save(@RequestBody Order user);

}
