package com.company.tarakan;

import java.util.List;
import java.util.Random;

public class Tarakan implements Runnable {

    private String name;

    private int distance;
    private List<Score> scores;

    private Random random = new Random();

    public Tarakan(String name, int distance, List<Score> scores) {
        this.name = name;
        this.distance = distance;
        this.scores = scores;
    }

    @Override
    public void run() {
        long start = System.currentTimeMillis();
        for (int i = 0; i < distance; i++) {
            int randomTime = random.nextInt(10) + 50;
            try {
                Thread.sleep(randomTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        long end = System.currentTimeMillis();
        long result = end - start;

        synchronized (scores) {
            scores.add(new Score(name, result));
        }
    }
}
