package com.company;

import java.util.*;
import java.util.stream.Collectors;

public class Hw {
    public static void main(String[] args) {
        String text = "What is Java technology and why do I need it? " +
                "Java is a programming language and computing platform first released" +
                " by Sun Microsystems in 1995. There are lots of applications and websites" +
                " that will not work unless you have Java installed, and more are created" +
                " every day. Java is fast, secure, and reliable. From laptops to datacenters" +
                ", game consoles to scientific supercomputers, cell phones to the Internet," +
                " Java is everywhere!";

        groupingTextByFirstChar(text);
        groupingTextByFirstCharUsingStream(text);
    }

    public static TreeMap<String, TreeSet<String>> groupingTextByFirstChar(String text) {
        List<String> words = Arrays.asList(text
                .replaceAll("[,.!?]", "")
                .toLowerCase()
                .split(" "));
        System.out.println(words);

        TreeMap<String, TreeSet<String>> resultMap = new TreeMap<>();

        for (String word : words) {
            String key = word.substring(0, 1);
            TreeSet<String> value = resultMap.get(key);

            if (value == null) {
                value = new TreeSet<>();
                value.add(word);
                resultMap.put(key, value);
            } else {
                value.add(word);
                resultMap.replace(key, value);
//                resultMap.get(key).add(word);
            }
        }

        return resultMap;
    }

    public static TreeMap<String, Set<String>> groupingTextByFirstCharUsingStream(String text) {
        List<String> words = Arrays.asList(text.replaceAll("[,.!?]", "").toLowerCase().split(" "));
        return words.stream().collect(Collectors.groupingBy(s -> s.substring(0, 1), TreeMap::new, Collectors.toSet()));
    }
}
