package com.xinyue.gateway.routes;

import org.springframework.cloud.gateway.filter.factory.AbstractNameValueGatewayFilterFactory.NameValueConfig;
import org.springframework.cloud.gateway.filter.factory.AddRequestHeaderGatewayFilterFactory;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

@Configuration
public class CustomRoutesConfiguration {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder, AddRequestHeaderGatewayFilterFactory throttle) {
        NameValueConfig requestHeader = new NameValueConfig();
        requestHeader.setName("routes-a");
        requestHeader.setValue("yes");
        return builder.routes()
                .route(r -> r.host("localhost:8080").and().path("/routes-api/a/**")
                    .filters(f ->{
                            f.addResponseHeader("X-TestHeader", "foobar");
                            return f.redirect(HttpStatus.MOVED_PERMANENTLY.value(), "http://www.xinyues.com");
                            })
                    .uri("http://localhost:8080").id("custom-1")
                )
                .route(r -> r.path("/routes-api/b/**")
                    .filters(f ->
                            f.addResponseHeader("X-AnotherHeader", "baz"))
                    .uri("http://localhost:8080").id("custom-2")
                )
                .route(r -> r.order(0)
                    .host("localhost:8080").and().path("/routes-api/c/**")
                    .filters(f -> f.filter(throttle.apply(requestHeader)))
                    .uri("http://localhost:8080").id("custom-3")
                )
                .build();
    }
}
