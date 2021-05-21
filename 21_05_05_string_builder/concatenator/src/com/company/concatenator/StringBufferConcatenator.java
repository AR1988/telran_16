package com.company.concatenator;

public class StringBufferConcatenator implements IConcatenator {

    @Override
    public void concate(String[] stringsToConcate) {
        StringBuffer stringBuffer = new StringBuffer();
        for (String str : stringsToConcate) {
            stringBuffer.append(str);
        }
    }
}
