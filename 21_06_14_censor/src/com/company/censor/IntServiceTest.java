package com.company.censor;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.Assert.*;

public class IntServiceTest {

    IntService intService = new IntService();

    @Test
    public void toConcat() {
        IntStream stream1 = IntStream.of(75, 35, 55);
        IntStream stream2 = IntStream.of(30, 60, 90, 20);
        IntStream intStream = intService.toConcat(stream1, stream2);

//        List<Integer> integers1 = new ArrayList<>();
//        intStream.forEach(value -> integers1.add(value));
//        System.out.println(integers1);

        List<Integer> integers2 = intStream
                .boxed()
                .collect(Collectors.toList());
        System.out.println(integers2);
    }

    @Test
    public void test_factorial() {
        long result = intService.factorial(5);
        assertEquals(120, result);
        assertEquals(5040, intService.factorial(7));
    }
}
