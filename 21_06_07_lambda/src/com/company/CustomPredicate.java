package com.company;

@FunctionalInterface
public interface CustomPredicate<T> {

    boolean test(T a1, T a2, T a3);
}
