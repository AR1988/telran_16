package com.company;

import com.company.genarator.RandomGenerator;
import com.company.genarator.rule.ListRandomStrategy;
import com.company.genarator.rule.RandomRule;
import com.company.genarator.rule.RangeRandomStrategy;

import java.util.Arrays;

/**
 * Генератор чисел списка случайных чисел.
 * <p>
 * Список генерируется по установленным правилам генерации.
 * </p>
 * Размер этого списка устанавливается при вызове метода генерации.
 * <code>
 * <pre>
 * ...
 * generator = new RandomGenerator(new SomeRule(...ruleArgs))
 *
 * List result = generator.nextInts(size);
 * <i>result = [1,25 ...55]</i>
 * </pre>
 * </code>
 */
public class Application {

    public static void main(String[] args) {
        RandomRule ruleRange = new RangeRandomStrategy(100);
//        List<Integer> list = Arrays.asList(10, 55, 555, 1185, -100);
//        RandomRule listRule = new ListRandomRule(list);
        RandomRule listRule = new ListRandomStrategy(Arrays.asList(10, 55, 555, 1185, -100));

//        RandomGenerator randomGeneratorRange = new RandomGenerator(ruleRange);
        RandomGenerator randomGeneratorRange = new RandomGenerator(
                new ListRandomStrategy(Arrays.asList(10, 55, 555, 1185, -100)));
        RandomGenerator randomGeneratorList = new RandomGenerator(listRule);

        System.out.println(randomGeneratorList.nextInts(2));
        System.out.println(randomGeneratorRange.nextInts(2));
    }
}
