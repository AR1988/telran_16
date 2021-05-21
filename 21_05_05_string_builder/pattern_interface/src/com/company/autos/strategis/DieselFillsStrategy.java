package com.company.autos.strategis;

public class DieselFillsStrategy implements FillStrategy {

    @Override
    public void fill() {
        System.out.println("Заправлять дизелем");
    }
}
