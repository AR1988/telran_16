package com.example.hello_web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.websocket.server.PathParam;
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
    @GetMapping("/hello2/{userName}")
    public String c(@PathVariable(name = "userName") String name, Model model) {
        String str = "Name from url: " + name.toUpperCase();

        model.addAttribute("userName", str);
        model.addAttribute("text", "Lorem ipsum dolor sit amet, consectetur adipisicing elit." +
                " Ab, ad corporis dolor dolorum error esse id inventore ipsa" +
                "    labore laboriosam laudantium libero necessitatibus perferendis," +
                " porro quam rerum vel? Mollitia, perspiciatis.");

        List<String> strings = Arrays.asList("str1", "str2");
        model.addAttribute("strings", strings);


        return "hello";
    }
}
