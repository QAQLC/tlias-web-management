package com.tlias.controller;

import org.springframework.web.bind.annotation.GetMapping;


public class HelloWorld {
    @GetMapping("/hello")
    public String hello () {
        return "hello world";
    }
}
