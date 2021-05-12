package com.company.autos;


import com.company.autos.strategis.FillStrategy;

public class Auto {

    private final FillStrategy strategy;

    public Auto(FillStrategy strategy) {
        this.strategy = strategy;
    }

    public void go() {
        System.out.println("On the way");
    }

    public void stop() {
        System.out.println("Stooped");
    }

    public void fill() {
        strategy.fill();
    }
}
