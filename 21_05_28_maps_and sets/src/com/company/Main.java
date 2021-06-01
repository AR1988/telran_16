package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap();
        map.put("Hallo", "DE, Привет");
        map.put("Hello", "EN, Привет");
        map.put("Hola", "ES, Привет");
        map.put(null, "null - - - ");
        System.out.println(map.get(null));
//        Scanner scanner = new Scanner(System.in);
//        String word = scanner.nextLine();
//        if (map.containsKey(word))
//            System.out.println(map.get(word));

        map.clear();

        map.put("aaa", "aaa");
        map.put("ddd", "ddd");
        map.put("rrr", "rrr");
        map.put("xxx", "xxx");
        map.put("zzz", "zzz");
        map.put("aba", "aba");
        System.out.println(map);

        Comparator comparator = (Comparator<String>) (o1, o2) -> o2.compareTo(o1);

        TreeMap<String, String> treeMap = new TreeMap<>();
        treeMap.put("aaa", "aaa");
        treeMap.put("ddd", "ddd");
        treeMap.put("rrr", "rrr");
        treeMap.put("xxx", "xxx");
        treeMap.put("zzz", "zzz");
        treeMap.put("aba", "aba");
        System.out.println(treeMap);
        System.out.println(treeMap.subMap("aba", "zzz"));

        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("aaa", "aaa");
        linkedHashMap.put("ddd", "ddd");
        linkedHashMap.put("rrr", "rrr");
        linkedHashMap.put("xxx", "asdasd");
        linkedHashMap.put("zzz", "zzz");
        linkedHashMap.put("aba", "aba");
        System.out.println(linkedHashMap);

        task1();
    }

    private static void task1() {
        List<Integer> list = Arrays.asList(0, 1, 54, 38, 54, 84, 8431484, 584, 3, 3, 3, 0, 4154, 0, 384, 54134, 584341, 4, 5438);
//0:3
//1:1
//3:3
//4:1
//54:2 ...
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (Integer integer : list) {

            if (!map.containsKey(integer))
                map.put(integer, 1);
            else
                map.replace(integer, map.get(integer) + 1);
            System.out.println(map);
        }


    }
}
