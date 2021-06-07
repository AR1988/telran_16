package com.company.hw;

import com.company.task1.ResultInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game implements Runnable {

    private final int loopNumber;
    private final Auto auto;
    private List<FinishInfo> resultInfos;
    private final Random random = new Random();

    public Game(int loopNumber, Auto auto, List<FinishInfo> resultInfos) {
        this.loopNumber = loopNumber;
        this.auto = auto;
        this.resultInfos = resultInfos;
    }

    @Override
    public void run() {
        ArrayList<Long> loopTimes = new ArrayList<>();

        for (int i = 1; i <= loopNumber; i++) {
            long start = System.currentTimeMillis();

            if (i % 2 == 0) {
                int pitStopTime = getRandomTime(auto.getMinPitStopTime(), auto.getMaxPitStopTime());
                sleep(pitStopTime);
//                System.out.println("Auto: " + auto.getName()
//                        + " loop nr.: " + i + " Pit stop time: "
//                        + pitStopTime);
            }

            int loopTime = getRandomTime(auto.getMinLoopTime(), auto.getMaxLoopTime());
            sleep(loopTime);
            long end = System.currentTimeMillis();
            loopTimes.add(end - start);
        }

        long totalTime = 0;
        for (Long time : loopTimes)
            totalTime += time;

        synchronized (resultInfos) {
            FinishInfo finishInfo = new FinishInfo(auto.getName(), totalTime);
            resultInfos.add(finishInfo);
        }

//        System.out.println("---FINISH---");
//        System.out.println("Auto: " + auto.getName() + loopTimes);
//        System.out.println("Auto: " + auto.getName()
//                + " total time: " + totalTime);
    }

    public void sleep(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public int getRandomTime(int min, int max) {
        return random.nextInt(max - min) + min;
    }
}
