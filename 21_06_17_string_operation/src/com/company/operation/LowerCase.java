package com.company.operation;

public class LowerCase implements IStringOperation {

    @Override
    public String operate(String text) {
        return text.toLowerCase();
    }

    @Override
    public String getName() {
        return "to_lowerCase";
    }
}
