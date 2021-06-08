package com.company;

import java.util.*;
import java.util.function.UnaryOperator;

public class LambdaTasks2 {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("clojure", "java", "scala", "clojure", "java", "scala", "scala", "clojure");

        System.out.println(task1(list));
        System.out.println(task2("clojure"));
        task3();
    }

    //Написать лямбда выражение, которое принимает список строк, и возвращает новый список строк уникальный.
    private static List<String> task1(List<String> list) {
        UnaryOperator<List<String>> func = (strings) -> new ArrayList<>(new TreeSet(strings));
        return func.apply(list);
    }

    //    Написать лямбда выражение, которое вернет строку в обратном порядке
    private static String task2(String str) {
//        UnaryOperator<String> func = (text) -> new StringBuilder(text).reverse().toString();
        UnaryOperator<String> func = (text) -> {
            StringBuilder stringBuilder = new StringBuilder(text);
            StringBuilder reverse = stringBuilder.reverse();
            return reverse.toString();
        };
        return func.apply(str);
    }

//    Есть класс Student. У класса есть два поля имя и оценка. Создать список студентов.
//    1. Отсортировать список студентов по имени (A-Z).
//    2. Отсортировать список студентов по оценкам (9-0)
    private static void task3() {
        Comparator<Student> byName = (o1, o2) -> o1.getName().compareTo(o2.getName());
        Comparator<Student> byGrade = (o1, o2) -> o1.getExamGrade() - o2.getExamGrade();

        List<Student> students = Arrays.asList(
                new Student("APetja", 4),
                new Student("CMaria", 5),
                new Student("BVasja", 3)
        );
        System.out.println(students);
        students.sort(byName);
        System.out.println(students);
        students.sort(byGrade);
        System.out.println(students);
    }
}
