package com.company.operation;

public class Reverse implements IStringOperation {
    @Override
    public String operate(String text) {
        return new StringBuilder(text).reverse().toString();
    }

    @Override
    public String getName() {
        return "reverse";
    }
}
