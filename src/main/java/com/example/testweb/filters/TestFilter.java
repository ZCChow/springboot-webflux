package com.example.testweb.filters;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

/**
 * @Author: zxc
 * @Date: 2018/9/29 下午3:47
 * @Version 2
 */
@Configuration
public class TestFilter implements WebFilter {
    @Override
    public Mono<Void> filter(ServerWebExchange serverWebExchange, WebFilterChain webFilterChain) {
        System.out.println("11111");
        return webFilterChain.filter(serverWebExchange);


    }
}
