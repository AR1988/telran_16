package com.company.genarator;

import com.company.genarator.rule.RandomRule;

import java.util.ArrayList;
import java.util.List;

/**
 * Конструктор принимает правило: RandomRule rule
 * <code>
 * <pre>
 *  IRule rule = new SomeRule(...ruleArgs);
 *
 *  generator = new RandomGenerator(rule)
 *
 *  int resultListSize = 11;
 *  List result = generator.nextInts(resultListSize);
 *  result = [1,25 ...55]
 *     </pre>
 * </code>
 */
public class RandomGenerator {
    /**
     * @param size - количесвто генерируемых элеменов / размер возвращаемого списка
     * @return список чисел которые генерируются на основе правила <b>rule</b>
     * <p>
     * этот метод возвращает список чисел.
     * каждое число списка генерируется метотом определенном в правиле
     */
    public List<Integer> nextInts(int size) {
    }
}
