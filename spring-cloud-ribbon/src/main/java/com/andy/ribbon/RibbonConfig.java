package com.andy.ribbon;

import com.netflix.loadbalancer.*;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
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
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    /**
     * 配置随机负载策略，需要配置属性service-B.ribbon.NFLoadBalancerRuleClassName=com.netflix.loadbalancer.RandomRule
     */
    @Bean
    public IRule ribbonRule() {
        //  轮询
        return new RoundRobinRule();

        // 权重 根据平均响应时间计算所有服务的权重，响应时间越快服务权重越大被选中的概率越高。
        // return new WeightedResponseTimeRule();

        //  重试 先按照轮询策略获取服务，如果获取失败则在指定时间内重试，获取可用服务
        // return new RetryRule();

        // 选过滤掉多次访问故障而处于断路器跳闸状态的服务，然后选择一个并发量最小的服务
        // return new BestAvailableRule();

        // 符合判断server所在区域的性能和server的可用性选择服务
        // return new ZoneAvoidanceRule();

        // 随机
        // return new RandomRule();
    }
}

