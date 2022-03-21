package com.xinyue.gateway.fitlers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.cloud.gateway.support.ServerWebExchangeUtils;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;
@Service
public class MyGlobalFitlers implements GlobalFilter, Ordered{

    private Logger logger = LoggerFactory.getLogger(MyGlobalFitlers.class);
    @Override
    public int getOrder() {
        return 10001;
    }

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        Object value = exchange.getAttribute(ServerWebExchangeUtils.GATEWAY_REQUEST_URL_ATTR);
        Object after = exchange.getAttribute(ServerWebExchangeUtils.GATEWAY_ORIGINAL_REQUEST_URL_ATTR);
        logger.debug("global filters:{},{}",value,after);
        
        Object uri1 = exchange.getAttribute(ServerWebExchangeUtils.GATEWAY_SCHEME_PREFIX_ATTR);
        logger.debug("ServerWebExchangeUtils.GATEWAY_SCHEME_PREFIX_ATTR: {}",uri1);
        return chain.filter(exchange);  
    }

}
