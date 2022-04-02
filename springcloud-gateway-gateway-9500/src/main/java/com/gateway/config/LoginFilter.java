package com.gateway.config;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class LoginFilter implements GlobalFilter, Ordered {

    // 执行过滤器中的业务逻辑
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        System.out.println("----执行了全局过滤器----");
        // 1、获取请求参数access-token
        String token = exchange.getRequest().getQueryParams().getFirst("access-token");
        if (token == null){
            // 2、如果不存在，则认证失败
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
            // 3、直接请求结束返回
            return exchange.getResponse().setComplete();
        }

        // 4、放行
        return chain.filter(exchange);
    }

    // 指定过滤器的执行顺序，返回值越小，执行优先级越高
    public int getOrder() {
        return 0;
    }
}