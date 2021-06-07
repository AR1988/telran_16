package com.company.incrimenter;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicThread implements Runnable {

    private AtomicInteger atomicInteger;
    private int times;


    public AtomicThread(AtomicInteger atomicInteger, int times) {
        this.atomicInteger = atomicInteger;
        this.times = times;
    }

    @Override
    public void run() {
        for (int i = 0; i < times; i++) {
            atomicInteger.incrementAndGet();
//            atomicInteger.decrementAndGet();
        }
    }
}
