package com.example.hello_web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/api")
public class HelloWebController {

    // api/web
    @GetMapping("/web")
    public String a() {
        return "h";
    }

    // api/hello2
    @GetMapping
    public String b() {
        return "hello";
    }

    // api/
    @GetMapping("/hello2/{number}")
    public String c(@PathVariable int number, Model model) {

        List<String> strings = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            strings.add("str" + i);
        }

        model.addAttribute("strings", strings);

        return "hello";
    }
}
