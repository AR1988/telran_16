package com.company.incrimenter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Application {

    private static final int TIMES = 100_000;

    public static void main(String[] args) throws InterruptedException {
        Source source = new Source();
        AtomicInteger atomicInteger = new AtomicInteger();
        List<Thread> threads = new ArrayList<>();
        List<Thread> atomicThreads = new ArrayList<>();
        long start = System.currentTimeMillis();

        for (int i = 0; i < 2; i++) {
            threads.add(new Thread(new IncrementerThread(source, TIMES)));
        }
        for (int i = 0; i < 2; i++) {
            atomicThreads.add(new Thread(new AtomicThread(atomicInteger, TIMES)));
        }

        for (Thread thread : atomicThreads) {
            thread.start();
        }
        for (Thread thread : atomicThreads) {
            thread.join();
        }

        for (Thread thread : threads) {
            thread.start();
        }
        for (Thread thread : threads) {
            thread.join();
        }

        long end = System.currentTimeMillis();
//        System.out.println(end - start);
        System.out.println("result: " + source.getNumber());
        System.out.println("result atomic: " + atomicInteger.get());

//        start = System.currentTimeMillis();
//        int number = 0;
//        for (int i = 0; i < 500; i++) {
//            int temp = number + 1;
//            number = temp;
//            Thread.sleep(4);
//        }
//        end = System.currentTimeMillis();
//        System.out.println(end - start);
    }
}
