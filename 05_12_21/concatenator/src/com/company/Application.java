package com.company;

import com.company.concatenator.*;

import java.util.Arrays;
import java.util.List;

public class Application {

    public static void main(String[] args) {
//        IConcatenator stringConcatenator = new StringConcatenator();
//        IConcatenator stringBuilderConcatenator = new StringBuilderConcatenator();
//        IConcatenator stringBufferConcatenator = new StringBufferConcatenator();

//        ConcatenationTest concatenationTestString = new ConcatenationTest(stringConcatenator);
//        ConcatenationTest concatenationTestStringBuilder = new ConcatenationTest(stringBuilderConcatenator);
//        ConcatenationTest concatenationTestStringBuffer = new ConcatenationTest(stringBufferConcatenator);
//
        int times = 50_000;
//        concatenationTestString.test(10_000, "test");
//        concatenationTestStringBuilder.test(times, "test");
//        concatenationTestStringBuffer.test(times, "test");

        List<ConcatenationTest> list = Arrays.asList(
                new ConcatenationTest(new StringConcatenator()),
                new ConcatenationTest(new StringBuilderConcatenator()),
                new ConcatenationTest(new StringBufferConcatenator())
        );

        for (ConcatenationTest concatenationTest : list) {
            concatenationTest.test(times, "test");
        }
    }
}
