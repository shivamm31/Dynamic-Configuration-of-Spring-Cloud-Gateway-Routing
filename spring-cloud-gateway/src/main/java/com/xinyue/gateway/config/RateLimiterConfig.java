package com.xinyue.gateway.config;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.cloud.gateway.filter.ratelimit.RedisRateLimiter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Mono;

@Configuration
public class RateLimiterConfig {

    @Bean
    public KeyResolver ipKeyResolver() {
        return exchange-> Mono.just(exchange.getRequest().getRemoteAddress().getHostString());
    }
    @Bean
    public RedisRateLimiter myRateLimiter() {
        return new RedisRateLimiter(2, 4);   //这里需要指定默认的速率和令牌桶容量。如果配置文件中没有配置这两个值，就使用默认值
    }
}
