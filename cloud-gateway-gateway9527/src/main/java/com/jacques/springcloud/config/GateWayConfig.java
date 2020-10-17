package com.jacques.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Jacques·Fry
 * @version 1.0
 * @info GateWay配置
 * @date 2020/10/17 21:32
 */
@Configuration
public class GateWayConfig {


    /**
     * 配置路由
     * @param builder
     * @return
     */
    @Bean
    public RouteLocator baiduRouteLocator(RouteLocatorBuilder builder) {
        RouteLocatorBuilder.Builder routes = builder.routes();
        routes.route("path_route_jacques", r ->
                r.path("/guonei")
                        .uri("http://news.baidu.com/guonei")
        );
        return routes.build();
    }
}
