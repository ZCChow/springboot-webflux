package com.example.testweb.enity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Author: zxc
 * @Date: 2018/9/28 下午7:14
 * @Version 1.0
 */
@Data
@AllArgsConstructor
public class User {
        private long id;
        private String firstname;
        private String lastname;
        private int age;
}
