package com.company.operation;

public class AddSuffix implements IStringOperation {
    @Override
    public String operate(String text) {
        return text + " some suffix";
    }

    @Override
    public String getName() {
        return "add_suffix";
    }
}
