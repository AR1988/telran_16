package com.company;

import java.util.*;

//ДЗ Есть список слов. Создать Map, где ключ это первая буква слова, а значение это список слов, которые начинаются с тойже быквы что и ключ.
//Коллекция должна быть сортирована, слова не должны повторяться,
// Treemap<String, Set<String>> map;
//Пример: а = [автор, автобус, альясн], в : [вода, воздух], с : [сила, север, слово] ...

public class SetApplication {
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();
        set.add(4);
        set.add(1);
        set.add(1);
        set.add(2);
        set.add(6);
        set.add(1);
        set.add(1);
        System.out.println(set);

        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(4);
        treeSet.add(1);
        treeSet.add(1);
        treeSet.add(2);
        treeSet.add(6);
        treeSet.add(1);
        treeSet.add(1);
        System.out.println(treeSet);
        System.out.println(treeSet.subSet(2, 6));

        List<Integer> list = Arrays.asList(0, 1, 54, 38, 54, 84, 584, 3, 3, 3, 0, 4154, 0, 384, 4, 5438);

        HashSet<Integer> integers = new HashSet<>(list);
        TreeSet<Integer> integersT = new TreeSet<>(list);
        System.out.println(list);
        System.out.println(integers);
        System.out.println(integersT);
    }
}
