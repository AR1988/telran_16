package com.example.string_operation.service;

import org.springframework.stereotype.Component;

@Component
public class Reverse implements IOperation {

    @Override
    public String operate(String text) {
        return new StringBuilder(text).reverse().toString();
    }

    @Override
    public String getName() {
        return "reverse";
    }
}
