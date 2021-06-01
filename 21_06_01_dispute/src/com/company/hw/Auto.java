package com.company.hw;

public class Auto {

    String name;

    int minLoopTime;
    int maxLoopTime;

    int minPitStopTime;
    int maxPitStopTime;

    public Auto(String name, int minLoopTime, int maxLoopTime, int minPitStopTime, int maxPitStopTime) {
        this.name = name;
        this.minLoopTime = minLoopTime;
        this.maxLoopTime = maxLoopTime;
        this.minPitStopTime = minPitStopTime;
        this.maxPitStopTime = maxPitStopTime;
    }

    public String getName() {
        return name;
    }

    public int getMinLoopTime() {
        return minLoopTime;
    }

    public int getMaxLoopTime() {
        return maxLoopTime;
    }

    public int getMinPitStopTime() {
        return minPitStopTime;
    }

    public int getMaxPitStopTime() {
        return maxPitStopTime;
    }
}
