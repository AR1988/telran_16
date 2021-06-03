package com.company.task1;

import java.util.List;

public class GameThread implements Runnable {

    private Sportsmen sportsmen;
    private int time;
    private List<ResultInfo> resultInfoList;

    public GameThread(Sportsmen sportsmen, int time, List<ResultInfo> resultInfoList) {
        this.sportsmen = sportsmen;
        this.time = time;
        this.resultInfoList = resultInfoList;
    }

    @Override
    public void run() {
        int runtDistance = 0;
        int timeCounter = 0;

        while (timeCounter != time) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            timeCounter++;
            runtDistance += sportsmen.getSpeed();
            System.out.println("Sprotsmen name: " + sportsmen.getName() + " Distance: " + runtDistance);
        }


        System.out.println("Sportsmen name: " + sportsmen.getName() + " Total distance: " + runtDistance);
        ResultInfo resultInfo = new ResultInfo(sportsmen.getName(), runtDistance, time);
        resultInfoList.add(resultInfo);
    }
}
