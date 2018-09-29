package com.example.testweb.dao;

import com.example.testweb.enity.User;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: zxc
 * @Date: 2018/9/28 下午7:16
 * @Version 1.0
 */
@Service
public class UserRepositoryImpl  implements UserRepository{


    private Map<Long, User> users = new HashMap<Long, User>();

    @PostConstruct
    public void init() throws Exception {
        users.put(Long.valueOf(1), new User(1, "Jack", "Smith", 20));
        users.put(Long.valueOf(2), new User(2, "Peter", "Johnson", 25));
    }



    @Override
    public Mono<User> getUserById(Long id) {
        return Mono.just(users.get(id));
    }

    @Override
    public Flux<User> getAllUsers() {
        return Flux.fromIterable(this.users.values());
    }
}
