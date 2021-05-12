package com.company.concatenator;


public class StringConcatenator implements IConcatenator {

    @Override
    public void concate(String[] stringsToConcate) {
        String res = "";
        for (String str : stringsToConcate) {
            res += str;
        }
    }
}
