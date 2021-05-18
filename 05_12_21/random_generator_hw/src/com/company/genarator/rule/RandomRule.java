package com.company.genarator.rule;

/**
 * пример реализации
 * <code>
 * <pre>
 * class RandomRuleImpl implements RandomRule {
 *    ...
 *   public RandomRuleImpl (List nubmers){
 *       ....
 *   }
 *    int nextInt(){
 *      return nubmers * 2;
 *    }
 *
 *  RandomRule rr = new RandomRuleImpl(2);
 *  rr.nextInt //4
 * }
 * </pre>
 * </code>
 * <p>
 * </p>
 */
public interface RandomRule {

    int nextInt();
}
