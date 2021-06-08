package com.company;

import org.junit.Assert;
import org.junit.Test;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;

import static org.junit.Assert.*;

public class CalculatorTest {

    @Test
    public void testCalc_sum() {
        double a = 2;
        double b = 3;
        BinaryOperator<Double> sum = (x, y) -> x + y;
        double res = calculate(a, b, sum);
        Assert.assertEquals(5, res, 1.5);
    }

    @Test
    public void testCalc_multiply() {
        double a = 2;
        double b = 3;
        BinaryOperator<Double> fun = (x, y) -> x * y;
        double res = calculate(a, b, fun);
        Assert.assertEquals(6, res, 1.5);
    }

    @Test
    public void testCalc_subtract() {
        double a = 2;
        double b = 3;
        BinaryOperator<Double> fun = (x, y) -> x - y;
        double res = calculate(a, b, fun);
        Assert.assertEquals(-1, res, 1.5);
    }

    @Test
    public void testCalc_pow() {
        double a = 2;
        double b = 3;
        BinaryOperator<Double> fun = (x, y) -> Math.pow(x, y);
        double res = calculate(a, b, fun);
        Assert.assertEquals(8, res, 1.5);
    }

    public static double calculate(double a, double b, BiFunction<Double, Double, Double> function) {
        return function.apply(a, b);
    }
}
