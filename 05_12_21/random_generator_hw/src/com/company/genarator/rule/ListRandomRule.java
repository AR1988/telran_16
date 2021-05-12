package com.company.genarator.rule;

import java.util.Random;

/**
 * Коструктор принимает список чисел ListRandomRule(List<Integer> values)
 * <p>
 * реализует метод интерфейса RandomRule int nextInt()<br>метод возвращает случайное число из списка values
 * <p>
 * values - поле класса List<Integer> values
 * <br>
 * <i>
 * *random.nextInt(values.size()) - случайное число не больше размера списка
 * </i>
 */
public class ListRandomRule implements RandomRule {
    Random random = new Random();
}
