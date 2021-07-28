package com.example.hello_web.controller;

import com.example.hello_web.dto.PersonDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
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

        List<PersonDto> persons = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            persons.add(new PersonDto("Max", "Mustermann", 18 + i));
        }

        model.addAttribute("persons", persons);

        return "hello";
    }
}
