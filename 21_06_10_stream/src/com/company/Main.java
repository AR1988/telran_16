package com.company;

import java.util.*;
import java.util.stream.Collectors;


public class Main {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(-1);
        list.add(-5);
        list.add(1);
        list.add(2);
        list.add(3);
//
        Set<Integer> resultList = new HashSet<>();
        for (Integer integer : list) {
            if (integer > 1) {
                resultList.add(integer);
            }
        }
////        System.out.println(list);
//
//        resultList = list.stream()
//                .peek(integer -> System.out.println("peek before filter " + integer))
//                .filter(integer -> integer > 0)
//                .peek(integer -> System.out.println("peek after filter " + integer))
//                .collect(Collectors.toSet());
//        System.out.println(resultList);
//
//        Stream<Integer> integerStream1 = Stream.of(-1, -5, 1, 2, 3);
//        Stream<Integer> integerStream2 = Stream.of(-1, -5, 1, 2, 3);
//
//        IntStream intStream = IntStream.of(1, 2, 3, 4);
//        LongStream longStream = LongStream.of(1, 2, 3, 4);
//
//        Stream<Integer> integerStream = Stream.concat(integerStream1, integerStream2);
//
//        IntStream rangeStream = IntStream.range(0, 1000);
//        rangeStream.peek(System.out::println).sum();
//        //        IntStream rangeStream = IntStream.rangeClosed(0, 1000);

        map();
        anyMatch();

        task1();
    }

    //Предположим, у нас есть список слов, и мы хотим построить список из коротких слов (длина <4).
//Длинное слово должно быть в верхнем регистре, каждое исходное слово должно присутствовать в результате только один раз.
    private static void task1() {
        List<String> strings = Arrays.asList("Предположим", "регистре", "раз", "присутствовать", "есть", "список", "слов", "сВ", "ов", "раз", "регистре");

        //        String resultList = strings
        List<String> resultList = strings
                .stream()
                .filter(s -> s.length() < 4)
                .map(String::toUpperCase)
                .distinct()
//                .reduce(" ", (s, s2) -> s + s2);
                .collect(Collectors.toList());

        System.out.println(strings);
        System.out.println(resultList);
    }

    private static void anyMatch() {
        List<Integer> list = new ArrayList<>();
        list.add(-1);
        list.add(-5);
        list.add(4);
        list.add(8);
        list.add(22);
        list.add(10);
        list.add(10);
        list.add(10);


        boolean isNumber10Exist = list
                .stream()
                .skip(5)
//                .anyMatch(integer -> integer == 10);
                .allMatch(integer -> integer == 10);
//                .noneMatch(integer -> integer == 10);
        System.out.println(isNumber10Exist);
    }

    private static void map() {
        List<Integer> list = new ArrayList<>();
        list.add(-1);
        list.add(-5);
        list.add(4);
        list.add(8);
        list.add(22);
        list.add(10);
        list.add(10);
        list.add(10);

        List<Integer> list2 = new ArrayList<>();
        list.stream()

                .distinct()
                .sorted((o1, o2) -> o2 - o1)
//                .limit(4)
                .filter(integer -> integer >= 2)
//                .map(integer -> integer + 2)
                .collect(Collectors.toList());
        System.out.println(list2);
    }
}
