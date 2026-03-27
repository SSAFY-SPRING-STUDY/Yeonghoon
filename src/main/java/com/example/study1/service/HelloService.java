package com.example.study1.service;

import org.springframework.stereotype.Service;

@Service
public class HelloService {

    public String hi() {
        return "Hello, World!";
    }
}