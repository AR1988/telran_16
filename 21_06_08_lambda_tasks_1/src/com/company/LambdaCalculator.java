package com.company;

import java.util.function.BiFunction;

public class LambdaCalculator {

    //Что должен уметь этот метод
    // Складывать;
    // умножать;
    // делить;
    // вычитать;
    // возводить число aв степень b
    // находить максимальное число
    // находить мин число
    // Что нельзя использовать:

    // if-else;
    // charкак указатель операции;
    // switch-case;
    // и все остальное что вам придет в голову.

    // Что можно использовать:
    // Только лямбды, задание то на них.

    public static void main(String[] args) {
        BiFunction<Double, Double, Double> sum = (x, y) -> x + y;
        BiFunction<Double, Double, Double> multiply = (x, y) -> x * y;
        BiFunction<Double, Double, Double> subtract = (x, y) -> x - y;
        BiFunction<Double, Double, Double> pow = (x, y) -> Math.pow(x, y);
        BiFunction<Double, Double, Double> max = (x, y) -> Math.max(x, y);
        BiFunction<Double, Double, Double> min = (x, y) -> Math.min(x, y);
//        BinaryOperator<Double> min = (x, y) -> Math.min(x, y);

        double a = 2;
        double b = 3;
        System.out.println(calculate(a, b, sum));
        System.out.println(calculate(a, b, multiply));
        System.out.println(calculate(a, b, subtract));
        System.out.println(calculate(a, b, pow));
        System.out.println(calculate(a, b, max));
        System.out.println(calculate(a, b, min));
    }

    public static double calculate(double a, double b, BiFunction<Double, Double, Double> function) {
        return function.apply(a, b);
    }
}
