package com.example.hello_web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloWebController {

    @GetMapping("/web")
    public String a() {
        return "h";
    }

    @GetMapping("/hello2")
    public String b() {
        return "hello";
    }
}
