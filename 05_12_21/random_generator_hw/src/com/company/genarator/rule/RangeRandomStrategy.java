package com.company.genarator.rule;


import java.util.Random;

/**
 * Задача данного правила: вывести число, которое меньше либо равно установленного<br>
 * число мы устанавливаем при создании этого правила
 */
public class RangeRandomStrategy implements RandomRule {

    private final Random random;
    private int max;

    public RangeRandomStrategy(int max) {
        this.max = max;
        this.random = new Random();
    }

    @Override
    public int nextInt() {
        return random.nextInt(max + 1);
    }
}
