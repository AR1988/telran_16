package com.company.incrimenter;

public class Source {

    private int number;
//мютекс
    Object door1 = new Object();
    Object door2 = new Object();

    public void increment() throws InterruptedException {
//        the same
//        number++;
        synchronized (door1) {
            int temp = number + 1;
//            Thread.sleep(4);
            number = temp;
        }
    }

    public void decrement() throws InterruptedException {
        synchronized (door1) {
            int temp = number - 1;
//            Thread.sleep(4);
            number = temp;
        }
    }

    public int getNumber() {
        return number;
    }
}
