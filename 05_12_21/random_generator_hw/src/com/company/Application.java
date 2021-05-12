package com.company;

/**
 * Эта програма генерирует список случайных чисел.
 * <p>
 * Список генерируется по установленым правилами генерации.
 * <code>
 * <pre>
 * class Rule ... {
 *    ...
 *   public Rule (List nubmers){
 *       ....
 *   }
 *
 *    int nextInt(){
 *    int result = ...code to generate
 *      return result;
 *    }
 * }
 * </pre>
 * </code>
 * </p>
 * Длина этого списка устанавливается при вызове метода генерации списка
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
        // Создать правило
        // Создать генератор, с правилом
        // Вызвать метод генератора для генерации списка
    }
}
