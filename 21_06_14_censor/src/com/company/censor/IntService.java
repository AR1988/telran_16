package com.company.censor;

import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class IntService {
    //    Eсть два IntStream. Первый IntStream содержит четные числа, а второй IntStream содержит нечетные числа.
//    Создайте третий поток, содержащий числа из обоих потоков, которые делятся на 3 и 5.
//    Вернуть IntStream из метода шаблона, а не список целых чисел.
//    Два первых подходящих числа в отсортированном списке необходимо пропустить.
    public IntStream toConcat(IntStream intStream1, IntStream intStream2) {
        IntPredicate predicate1 = value -> value % 3 == 0;
        IntPredicate predicate2 = value -> value % 5 == 0;
        IntPredicate intPredicate = predicate1.and(predicate2);

        return IntStream
                .concat(intStream1, intStream2)
                .filter(intPredicate)
                .sorted()
                .skip(2);
    }

    // Найти факториал числа:
    public long factorial(long n) {
        LongStream range = LongStream.rangeClosed(1, n);
        return range
                .reduce((left, right) -> left * right)
                .orElse(-1);
    }

    // Напишите метод вычисления суммы нечетных чисел в заданном интервале (включительно) с помощью Stream.
    public long sumOddNumbersBetween(int a, int b) {
        IntStream range = IntStream.rangeClosed(a, b);
        return range
                .filter(value -> value % 2 == 0)
                .reduce((left, right) -> left + right)
                .orElse(-1);
    }

}
