package com.company.task2;

import java.util.ArrayList;
import java.util.List;

public class App {
    private static final int THREADS_NUMBER = 3;

    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < THREADS_NUMBER; i++) {
            threads.add(new CounterThread(counter, "thread_" + i));
        }
        for (Thread thread : threads) {
            thread.start();
        }

        while (true) {
            System.out.println("Thread name: " + threads.get(0).getName() + " " + threads.get(0).getState());
            System.out.println("Thread name: " + threads.get(1).getName() + " " + threads.get(1).getState());
            System.out.println("Thread name: " + threads.get(2).getName() + " " + threads.get(2).getState());
            Thread.sleep(150);
            System.out.println();
        }

    }
}
