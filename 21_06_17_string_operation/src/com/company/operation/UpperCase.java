package com.company.operation;

public class UpperCase implements IStringOperation {

    @Override
    public String operate(String text) {
        return text.toUpperCase();
    }

    @Override
    public String getName() {
        return "to_upperCase";
    }
}
