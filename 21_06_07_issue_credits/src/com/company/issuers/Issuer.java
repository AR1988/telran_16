package com.company.issuers;

import com.company.Score;

import java.util.List;
import java.util.Random;

public class Issuer implements Runnable {

    String name;
    int min;
    int max;

    int creditsNumber;
    List<Score> scores;
    Random random = new Random();

    public Issuer(String name, int min, int max, int creditsNumber, List<Score> scores) {
        this.name = name;
        this.min = min;
        this.max = max;
        this.creditsNumber = creditsNumber;
        this.scores = scores;
    }

    @Override
    public void run() {
        long start = System.currentTimeMillis();

        for (int i = 0; i < creditsNumber; i++) {
            int time = generateTime(min, max);
            sleep(time);
        }

        long end = System.currentTimeMillis();

        Score score = new Score(name, (end - start));
        synchronized (scores) {
            scores.add(score);
            //        scores.add(new Score(name, (end - start)));
        }
    }

    int generateTime(int min, int max) {
        return random.nextInt(max - min + 1) + min;
    }

    void sleep(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
