package com.example.study1;

import org.springframework.stereotype.Service;

@Service
public class HelloService {

    public String hi() {
        return "Hello, World!";
    }
}