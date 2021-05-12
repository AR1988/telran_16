package com.company;

import com.company.concatenator.IConcatenator;

import java.util.Arrays;

public class ConcatenationTest {
    private IConcatenator concatenator;

    public ConcatenationTest(IConcatenator concatenator) {
        this.concatenator = concatenator;
    }

    public void test(int times, String text) {
        String[] arrayToConcate = createArray(times, text);

        long beforeTest = System.currentTimeMillis();
        concatenator.concate(arrayToConcate);
        long afterTest = System.currentTimeMillis();
        System.out.println(afterTest - beforeTest);
    }

    private String[] createArray(int times, String text) {
        String[] res = new String[times];
        Arrays.fill(res, text);
        return res;
    }
}
