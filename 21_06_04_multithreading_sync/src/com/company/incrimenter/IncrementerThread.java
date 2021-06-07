package com.company.incrimenter;

public class IncrementerThread implements Runnable {

    private Source source;
    private int times;


    public IncrementerThread(Source source, int times) {
        this.source = source;
        this.times = times;
    }

    @Override
    public void run() {
        for (int i = 0; i < times; i++) {
            try {
                source.increment();
                source.decrement();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
