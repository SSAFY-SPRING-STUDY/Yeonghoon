package com.springlecture.domain.post.service;

import org.springframework.stereotype.Service;

@Service
public class HelloService {

    public String hi() {
        return "Hello, World!";
    }
}