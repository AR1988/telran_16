package com.company.autos.strategis;

public class BenzineFillStrategy implements FillStrategy {
    @Override
    public void fill() {
        System.out.println("Заправляем бензином");
    }
}
