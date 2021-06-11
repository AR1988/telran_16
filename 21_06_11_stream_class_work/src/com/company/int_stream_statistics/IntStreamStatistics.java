package com.company.int_stream_statistics;

import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;

public class IntStreamStatistics {

    public static void main(String[] args) {
        IntStream intStream = IntStream.rangeClosed(0, 100_000);
        IntSummaryStatistics statistics = intStream.summaryStatistics();

        System.out.println(statistics);
        //максимальное значение
        System.out.println(statistics.getMax());
        //мин значение
        System.out.println(statistics.getMin());
        //среднее значение
        System.out.println(statistics.getAverage());
        System.out.println(statistics.getCount());
        System.out.println(statistics.getCount());
        System.out.println(statistics.getSum());
        //Вы не можете сделать то же самое с Stream <Integer>
    }
}

