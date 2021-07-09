package com.example.string_operation.service;

import org.springframework.stereotype.Component;

@Component
public class AddSuffix implements IOperation {

    @Override
    public String operate(String text) {
        return text + " some suffix";
    }

    @Override
    public String getName() {
        return "add_suffix";
    }
}
