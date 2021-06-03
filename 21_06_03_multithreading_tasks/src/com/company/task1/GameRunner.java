package com.company.task1;

import java.util.ArrayList;
import java.util.List;

public class GameRunner {

    public static final int SPORTSMEN_NUMBER = 10;
    public static final int TIME = 3;

    public static void main(String[] args) throws InterruptedException {
        List<Sportsmen> sportsmenList = new ArrayList<>();
        for (int i = 1; i <= SPORTSMEN_NUMBER; i++)
            sportsmenList.add(new Sportsmen("Sportsmen nr_" + i, 4 + i));

        List<ResultInfo> resultInfoList = new ArrayList<>();

        List<Thread> threadsList = new ArrayList<>();
        for (Sportsmen sportsmen : sportsmenList)
            threadsList.add(new Thread(
                    new GameThread(sportsmen, TIME, resultInfoList)));

        for (Thread thread : threadsList) {
            thread.start();
        }

        for (Thread thread : threadsList) {
            thread.join();
        }

        System.out.println(resultInfoList.size());
        for (ResultInfo resultInfo : resultInfoList) {
            System.out.println("name: " + resultInfo.getName() + " dist: " + resultInfo.getResultDistance());
        }
//        System.out.println(resultInfoList);

//        for (Thread thread : threadsList) {
//            thread.join();
//        }

//        Thread th1 = threadsList.get(0);
//        Thread th2 = threadsList.get(1);
//        Thread th3 = threadsList.get(2);
//
//        System.out.println(th1.getState());
//        th1.start();
//        System.out.println(th1.getState());
//        System.out.println(th2.getState());
//        th1.join();
//        System.out.println(th1.getState());
//
//        System.out.println(th2.getState());
//        th2.start();
//        th3.start();
//        System.out.println(th3.getState());
//        th2.join();
//        System.out.println(th1.getState());
//
//        th3.join();
        System.out.println("--- end ---");
    }
}
