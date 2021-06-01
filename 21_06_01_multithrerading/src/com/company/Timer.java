package com.company;

public class Timer extends Thread {

    int counter;

    public Timer(int counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = counter; i >= 0; i--) {
            System.out.println(i);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
