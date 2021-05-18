package com.company.genarator;

import com.company.genarator.rule.RandomRule;

import java.util.ArrayList;
import java.util.List;

/**
 * Задача этого класса: генерация списка чисел на основе установленого правила RandomRule<br>
 * RandomRule мы устанавливаем при создании этого правила.
 * <p>
 * Этот класс содержит метод для генерации списка чисел<br>
 * Числа в списке генерируются на основе установленого правила RandomRule
 * <p>
 * Пример:
 * <code>
 * <pre>
 *
 *  IRule rule = new SomeRule(...ruleArgs);
 *
 *  generator = new RandomGenerator(rule)
 *
 *  int resultListSize = 11;
 *  List result = generator.nextInts(resultListSize);
 *
 *  <i>result = [1,25 ...55]</i>
 *  <i>result.size() is 11</i>
 *
 *     </pre>
 * </code>
 */
public class RandomGenerator {


    private final RandomRule rule;

    public RandomGenerator(RandomRule rule) {
        this.rule = rule;
    }

    /**
     * @param size - количесвто генерируемых элеменов / размер возвращаемого списка
     * @return список чисел, которые генерируются на основе правила <b>rule</b>
     * <p>
     * каждое число списка генерируется методом, определенным в правиле
     */
    public List<Integer> nextInts(int size) {
        List<Integer> resultList = new ArrayList<>();

        for (int i = 1; i <= size; i++) {
            int generatedNumber = rule.nextInt();
            resultList.add(generatedNumber);
        }
        return resultList;
    }
}
