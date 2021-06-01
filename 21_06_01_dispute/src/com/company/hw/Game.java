package com.company.hw;

import java.util.Random;

public class Game implements Runnable {

    int loopNumber;
    Auto auto;

    public Game(int loopNumber, Auto auto) {
        this.loopNumber = loopNumber;
        this.auto = auto;
    }

    @Override
    public void run() {
        for (int i = 0; i < loopNumber; i++) {
            long start = System.currentTimeMillis();
            if (i % 2 == 0) {
//                pit stop
            }

            System.out.println("loop nr: " + i);
        }
    }
}
