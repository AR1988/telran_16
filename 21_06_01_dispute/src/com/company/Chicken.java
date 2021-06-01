package com.company;

public class Chicken implements Runnable {
    int counter;

    public Chicken(int counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < counter; i++) {
            System.out.println("Chicken");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
