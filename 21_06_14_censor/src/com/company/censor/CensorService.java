package com.company.censor;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CensorService {

    // Напишите программу, которая будет обнаруживать плохие слова в тексте в соответствии со списком плохих слов.
    // Все слова в тексте разделяются пробелам. Вывести список плохих слов в тексте.
    // Результат должен быть отсортирован, и слова не должны повторяться

    public List<String> badWordsV1(String text, List<String> badWords) {
        List<String> textToArray = Arrays.asList(text.split(" "));
        List<String> badWordsToLowerCase = badWords.stream().map(String::toLowerCase).collect(Collectors.toList());
        return textToArray
                .stream()
//                .map(s -> s.toLowerCase())
                .map(String::toLowerCase)
                .filter(s -> badWordsToLowerCase.contains(s))
                .distinct()
                .sorted()
                .collect(Collectors.toList());
    }

    public List<String> badWordsV2(String text, List<String> badWords) {
        String textToLowerCase = text.toLowerCase();
        return badWords
                .stream()
                .map(String::toLowerCase)
//                .filter(s -> text.contains(s))
                .filter(textToLowerCase::contains)
                .distinct()
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());
    }
}
