package com.example.string_operation.service;

import org.springframework.stereotype.Component;

@Component
public class UpperCase implements IOperation {

    @Override
    public String operate(String text) {
        return text.toUpperCase();
    }

    @Override
    public String getName() {
        return "to_upperCase";
    }
}
