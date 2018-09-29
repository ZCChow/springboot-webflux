package com.example.testweb.route;

import com.example.testweb.filters.TestHandlerFilterFunction;
import com.example.testweb.handler.UserHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
/**
 * @Author: zxc
 * @Date: 2018/9/28 下午7:21
 * @Version 1.0
 */
@Configuration
public class RoutingConfiguration {


    private final TestHandlerFilterFunction testHandlerFilterFunction;

    public RoutingConfiguration(TestHandlerFilterFunction testHandlerFilterFunction) {
        this.testHandlerFilterFunction = testHandlerFilterFunction;
    }

    @Bean
    public RouterFunction<ServerResponse> monoRouterFunction(UserHandler userHandler) {
        return  route(GET("/api/user/index").and(accept(MediaType.APPLICATION_JSON)), userHandler::getAll)
                .andRoute(GET("/api/user/{id}").and(accept(MediaType.APPLICATION_JSON)), userHandler::getUser).filter(testHandlerFilterFunction);
    }
}
