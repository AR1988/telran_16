package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class LambdaTask {

//1 есть три числа,  doublea= 1.5; doubleb= 2; doublec= 2; посчитать сумму этих чисел и умножить на число n. n-аргумент лямбды выражения
//2 Есть строка "200". Распарсить строку в лонг и умножить на 2 внутри лямбды. Используйте интерфейс Function...

//  3
//  Сделайте что бы код заработал
//  public staticvoid main(String[] args)
//  {List<Integer> list= Arrays.asList(1, 2, 3, 4, 5, 6, 7);
//  System.out.print("Выводитвсечисла: ");System.out.print("Не выводит ни одного числа: ");...
//  System.out.print("Вывод четных чисел: ");...    System.out.print("Вывод нечетных чисел: ");...
//  System.out.print("Выводчиселбольше5: ");...}publicstaticvoidevaluate(List<Integer> list, ...)
//  {for (Integer n : list) {if ( ... ) {System.out.print(n + " ");}}System.out.println();}

// 4 - class Task4
// Дописать метод. Метод принимает два double и еще что то...
// Что должен уметь этот метод //Складывать;//умножать;//делить;//вычитать;//возводить число aв степень b//находить максимальное число//находить мин число
// Что нельзя использовать://if-else; // char как указатель операции;//switch-case;//и все остальное что вам придет в голову.
// Что можно использовать://Только лямбды, задание то на них.public static double calculate(double a, double b, ....) {return ....;}


    public static void main(String[] args) {
        task1(2.5, .5, 3.7, 2);
        task1(3.5, .5, 3.4, 3);

        long res2 = task2("200");
        System.out.println(res2);
        task3();
    }

    public static void task3() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);

        System.out.print("Выводит все числа: ");
        Predicate<Integer> pr1 = (num) -> true;
        evaluate(list, pr1);

        System.out.print("Не выводит ни одного числа: ");
        Predicate<Integer> pr2 = (num) -> false;
        evaluate(list, pr2);

        System.out.print("Вывод четных чисел: ");
        Predicate<Integer> pr3 = (num) -> num % 2 == 0;
        evaluate(list, pr3);

        System.out.print("Вывод нечетных чисел: ");
//        Predicate<Integer> pr4 = (num) -> num % 2 != 0;
//        evaluate(list, pr4);
        evaluate(list, (num) -> num % 2 != 0);

        System.out.print("Вывод чисел больше 5: ");
//        Predicate<Integer> pr5 = (num) -> num > 5;
//        evaluate(list, pr5);
        evaluate(list, (num) -> num > 5);
    }

    public static List<Integer> evaluate(List<Integer> list, Predicate<Integer> predicate) {
        List<Integer> result = new ArrayList<>();
        for (Integer n : list) {
            if (predicate.test(n)) {
                result.add(n);
                System.out.print(n + " ");
            }
        }
        System.out.println();
        return result;
    }

    public static Long task2(String str) {
        Function<String, Long> convertToLong = (line) -> Long.parseLong(line) * 2;
        return convertToLong.apply(str);
    }

    public static double task1(double x, double y, double z, double n) {
//        1
        UnaryOperator<Double> operator = (number) -> (x + y + z) * number;
        double res = operator.apply(n);
        System.out.println(res);
//        2
//        Function<Double, Integer> operator2 = (number) -> (int) ((x + y + z) * number);
//        res = operator2.apply(n);
//        System.out.println(res);
        return res;
//        3
//        Consumer<Double> consumer = (number) -> {
////            double res2 = operator2.apply(n);
//            double res2 = (x + y + z) * number;
//            System.out.println(res2);
//        };
//        consumer.accept(n);
    }
}
