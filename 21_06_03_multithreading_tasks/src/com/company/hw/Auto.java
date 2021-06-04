package com.company.hw;

public class Auto  {

   private final String name;

    private final int minLoopTime;
    private final int maxLoopTime;

    private final int minPitStopTime;
    private final int maxPitStopTime;

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
