package com.company;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Thread th1 = new Thread(new Egg(4));
        Thread th2 = new Thread(new Chicken(4));

        th1.start();
//        th1.join();
        th2.start();
//        th2.join();

        while (true) {

            if (!th1.isAlive()) {
                System.out.println("th1 won");
                th2.join();
            } else if (!th2.isAlive()) {
                System.out.println("th2 won");
                th1.join();
            }

            if (!th2.isAlive() && !th1.isAlive()) {
                System.out.println("End of threads");
                break;
            }
        }
    }
}
