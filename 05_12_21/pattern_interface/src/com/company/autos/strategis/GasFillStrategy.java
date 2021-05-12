package com.company.autos.strategis;

public class GasFillStrategy implements FillStrategy {
    @Override
    public void fill() {
        System.out.println("Заправляем бензином");
    }
}
