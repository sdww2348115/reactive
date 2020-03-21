package com.sdww8591.webflux.controller;

import com.sdww8591.webflux.entity.Demo;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @GetMapping
    public Mono<String> sayHello(String body) {
        return Mono.just("hello world");
    }

    @PostMapping("/post")
    public Mono<?> post(@RequestBody Demo body, ServerWebExchange serverWebExchange) {
        return Mono.just("aaa");
    }
}
