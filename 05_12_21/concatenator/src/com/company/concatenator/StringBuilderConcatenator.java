package com.company.concatenator;


public class StringBuilderConcatenator implements IConcatenator {

    @Override
    public void concate(String[] stringsToConcate) {
        StringBuilder stringBuffer = new StringBuilder();
        for (String str : stringsToConcate) {
            stringBuffer.append(str);
        }
    }
}
