package com.company.genarator.rule;

import java.util.List;
import java.util.Random;

/**
 * Задача данного правила: выводить любое число из установленного нами списка.
 * Список, List<Integer> мы устанавливаем при создании этого правила
 */
public class ListRandomStrategy implements RandomRule {

    private Random random;
    private List<Integer> list;

    public ListRandomStrategy(List<Integer> list) {
        this.list = list;
        this.random = new Random();
    }

    @Override
    public int nextInt() {
        return list.get(random.nextInt(list.size()));
    }
}
