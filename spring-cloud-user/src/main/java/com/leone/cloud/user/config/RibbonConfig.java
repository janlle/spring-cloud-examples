package com.leone.cloud.user.config;

import com.netflix.loadbalancer.AvailabilityFilteringRule;
import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * <p>
 *
 * @author leone
 * @since 2019-04-04
 **/
@Configuration
public class RibbonConfig {

    /**
     * 实例化ribbon使用的RestTemplate
     *
     * @return
     */
    @Bean
    // @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    /**
     * 配置随机负载策略，需要配置属性mc-user.ribbon.NFLoadBalancerRuleClassName=com.netflix.loadbalancer.RandomRule
     */
    //@Bean
    public IRule ribbonRule() {
        //  轮询
        // return new RoundRobinRule();

        // 权重 根据平均响应时间计算所有服务的权重，响应时间越快服务权重越大被选中的概率越高。
        // return new WeightedResponseTimeRule();

        //  重试 先按照轮询策略获取服务，如果获取失败则在指定时间内重试，获取可用服务
        // return new RetryRule();

        // 选择一个最小的并发请求的server
        // return new BestAvailableRule();

        // 符合判断server所在区域的性能和server的可用性选择服务
        // return new ZoneAvoidanceRule();

        // 随机
        // return new RandomRule();

        // 过滤掉那些因为一直连接失败的被标记为circuit tripped的后端server，并过滤掉那些高并发的的后端server（active connections 超过配置的阈值）
        return new AvailabilityFilteringRule();
    }
}

