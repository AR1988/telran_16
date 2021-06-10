package com.company;

import java.util.*;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class Main {

    public static void main(String[] args) {
        System.out.println(task4(" a1 ", " a2 ", " a3 ", " a4 ", " a5 ", " a6 ", " a7 "));
        System.out.println(task5(2, 1, 2));
        System.out.println(task5(1, 1, 1));
        System.out.println(task5(2, 3, 4));


        List<Integer> list = Arrays.asList(1, 1, 2, 3, 4, 7, 2, 5, 6, 7);
        System.out.println(task6(list));

        System.out.println(task7(list, ((o1, o2) -> o2 - o1)));
        System.out.println(task7(list, ((o1, o2) -> o1 - o2)));
    }

    //    Есть список чисел, избавиться от дубликатов в списке с помощью лямбды.
//    И отсортировать в любом порядке. Используйте Function<…. , ….>
    private static TreeSet<Integer> task7(List<Integer> list, Comparator<Integer> comparator) {
//        Function<List<Integer>, TreeSet<Integer>> function = c -> new TreeSet<Integer>(c);
        Function<List<Integer>, TreeSet<Integer>> function = TreeSet::new;

        TreeSet<Integer> naturalOrder = function.apply(list);
        TreeSet<Integer> integers = new TreeSet<>(comparator);

        integers.addAll(naturalOrder);
        return integers;
    }

    //    Есть список целых чисел.
//    Создать новый список из чисел первого списка. Каждое число в новом списке, должно быть умножено на 2.
    private static List<Integer> task6(List<Integer> list) {
        UnaryOperator<List<Integer>> operator = integers -> {
            List<Integer> resList = new ArrayList<>();
            for (Integer integer : list) {
                resList.add(integer * 2);
            }
            return resList;
        };
        return operator.apply(list);
    }

    //Написать свой функциональный интерфейс (TernaryIntPredicate) и использовать его для лямды выражения.
//Метод интерфейса должен принимать 3 аргумента типа int и возвращать значение boolean.
//Лямбда-выражение должно возвращать истину, если все переданные значения отличаются, в противном случае – ложь
    private static boolean task5(int a, int b, int c) {
        TernaryIntPredicate predicate = (x, y, z) -> x != y && y != z && z != x;
        return predicate.test(a, b, c);
    }

    //    Есть 7 строк. Задача, с помощью лямбды выражения склеить все эти строки и изменить регистр результата toUpperCase.
    private static String task4(String s1, String s2, String s3, String s4, String s5, String s6, String s7) {
        ConcatFunc concatFunc =
                (str1, str2, str3, str4, str5, str6, str7) -> str1 + str2 + str3 + str4 + str5 + str6 + str7;
        String result = concatFunc.apply(s1, s2, s3, s4, s5, s6, s7);

        ConcatFuncImpl impl = new ConcatFuncImpl();
        result = impl.apply(s1, s2, s3, s4, s5, s6, s7);
        return result;
    }

}
