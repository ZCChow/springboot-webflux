package com.example.testweb.filters;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.HandlerFilterFunction;
import org.springframework.web.reactive.function.server.HandlerFunction;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

/**
 * @Author: zxc
 * @Date: 2018/9/29 下午3:51
 * @Version 1.0
 */
@Configuration
public class TestHandlerFilterFunction implements HandlerFilterFunction<ServerResponse, ServerResponse>{

    @Override
    public Mono<ServerResponse> filter(ServerRequest serverRequest, HandlerFunction<ServerResponse> handlerFunction) {
        System.out.println(3333);
        return handlerFunction.handle(serverRequest);
    }
}
