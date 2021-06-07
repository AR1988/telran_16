package com.company.tarakan;

import java.util.ArrayList;
import java.util.List;

public class Runner {

    private static final int THREADS_NUMBER = 1500;
    private static final int DISTANCE = 15;

    public static void main(String[] args) throws InterruptedException {
        List<Thread> threads = new ArrayList<>();

        List<Score> scores = new ArrayList<>();
        for (int i = 0; i < THREADS_NUMBER; i++) {
            threads.add(new Thread(new Tarakan("tarakan_" + i, DISTANCE, scores)));
        }
        for (Thread thread : threads) {
            thread.start();
        }
        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println(scores.size());
//        for (Score score : scores) {
//            System.out.println(score.getName() + " score: " + score.getResult());
//        }
    }
}
