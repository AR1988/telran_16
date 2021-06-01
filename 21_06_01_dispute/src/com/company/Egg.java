package com.company;

public class Egg implements Runnable {

    int counter;

    public Egg(int counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < counter; i++) {
            System.out.println("Egg");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
