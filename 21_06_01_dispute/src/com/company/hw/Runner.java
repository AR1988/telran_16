package com.company.hw;

import java.util.ArrayList;
import java.util.List;

public class Runner {

    final static int AUTOS_NUMBER = 15;
    final static int LOOPS_NUMBER = 15;

    public static void main(String[] args) throws InterruptedException {
        List<Auto> autoList = new ArrayList<>();
        for (int i = 1; i <= AUTOS_NUMBER; i++) {
            autoList.add(
                    new Auto("Auto: " + i,
                            120 + i,
                            150 + i,
                            10 + i,
                            15 + i));
        }

        List<Thread> threads = new ArrayList<>();
        for (Auto auto : autoList) {
            threads.add(new Thread(new Game(LOOPS_NUMBER, auto)));
        }

        for (Thread thread : threads) {
            thread.start();
//                        thread.join();
        }

//        for (Thread thread : threads) {
//            thread.join();
//        }

//        System.out.println("end of main thread");
    }
}
