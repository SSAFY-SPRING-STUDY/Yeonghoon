package com.example.study1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    private final HelloService helloService;

    @Autowired
    public HelloController(HelloService helloService) {
        // 깃허브 브랜치 테스트용 주석
        this.helloService = helloService;
    }

    @GetMapping("/hello")
    public String hello() {
        String helloString = helloService.hi();
        return helloString;
    }
}
