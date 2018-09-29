package com.example.testweb.dao;

import com.example.testweb.enity.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @Author: zxc
 * @Date: 2018/9/28 下午7:15
 * @Version 1.0
 */
public interface UserRepository {
    public Mono<User> getUserById(Long id);

    public Flux<User> getAllUsers();
}
