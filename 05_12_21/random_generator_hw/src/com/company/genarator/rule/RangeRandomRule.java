package com.company.genarator.rule;

import com.company.genarator.rule.RandomRule;

import java.util.Random;

/**
 * Коструктор принимает число RangeRandomRule(int maxNumber)
 * maxNumber
 * реализует метод интерфейса RandomRule int nextInt()
 * метод возвращает случайное число, которое не больше числа maxNumber
 */
public class RangeRandomRule implements RandomRule {
    private Random random = new Random();
    private int max;

}
