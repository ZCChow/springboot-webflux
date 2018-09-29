package com.example.testweb.handler;

import com.example.testweb.dao.UserRepository;
import com.example.testweb.enity.User;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.BodyInserters.fromObject;

/**
 * @Author: zxc
 * @Date: 2018/9/28 下午7:19
 * @Version 1.0
 */
@Configuration
public class UserHandler {
    private final UserRepository customerRepository;

    public UserHandler(UserRepository repository) {
        this.customerRepository = repository;
    }


    public Mono<ServerResponse> getAll(ServerRequest request) {
        // fetch all customers from repository
        Flux<User> customers = customerRepository.getAllUsers();
        System.out.println(2222222);

        // build response
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(customers, User.class);
    }



    /**
     * GET a User by ID
     */
    public Mono<ServerResponse> getUser(ServerRequest request) {
        // parse path-variable
        long customerId = Long.valueOf(request.pathVariable("id"));

        // build notFound response
        Mono<ServerResponse> notFound = ServerResponse.notFound().build();

        // get customer from repository
        Mono<User> customerMono = customerRepository.getUserById(customerId);

        // build response
        return customerMono
                .flatMap(customer -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(fromObject(customer)))
                .switchIfEmpty(notFound);
    }


}
