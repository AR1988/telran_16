package com.company.home_work;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class HwStreams {

    public static void main(String[] args) {
        String str = "A stream is a body of water with surface water flowing within the bed and banks of a channel";
        List<String> strings = Arrays.asList(str.split(" "));
        int n = 4;

//Есть лист строк. составить одну строку из листа длиной больше n,
//// ToUpperCase, исключить повторения и отсортировать а-я
        System.out.println(task3(strings, n));

//Есть лист строк, вернуть лист строк, длина которых меньше n, исключить повторения
        List<String> resultTask2 = task2(strings, n);
        System.out.println(resultTask2);

//Есть лист строк, найти количество слов в листе, длина которых меньше n
        int result = task1(strings, n);
        System.out.println(result);

//Есть лист строк, узнать содержится в списке переданное слово, используя stream API.
        System.out.println(isContains(strings, "body"));
    }

    //Есть лист строк, узнать содержится в списке переданное слово, используя stream API.
    public static boolean isContains(List<String> wordsList, String word) {
        return wordsList.stream().anyMatch(s -> s.equals(word));
    }

    //Есть лист строк, найти количество слов в листе, длина которых меньше n
    private static int task1(List<String> strings, int n) {
        return (int) strings.stream()
                .filter(s -> s.length() < n)
                .count();
//                .collect(Collectors.toList()).size();
    }


    //Есть лист строк, вернуть лист строк, длина которых меньше n, исключить повторения
    private static List<String> task2(List<String> strings, int n) {
        return strings.stream()
                .filter(s -> s.length() < n)
                .distinct()
                .collect(Collectors.toList());
    }

    //Есть лист строк. составить одну строку из листа длиной больше n,
// ToUpperCase, исключить повторения и отсортировать а-я
    private static String task3(List<String> strings, int n) {
        return strings
                .stream()
                .filter(s -> s.length() > n)
                .sorted(Comparator.reverseOrder())
                .map(String::toUpperCase)
                .reduce("", (res, str) -> res + str);
    }
}
