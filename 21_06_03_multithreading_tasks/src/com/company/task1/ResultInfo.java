package com.company.task1;

public class ResultInfo {

    private String name;
    private int resultDistance;
    private int time;

    public ResultInfo(String name, int resultDistance, int time) {
        this.name = name;
        this.resultDistance = resultDistance;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getResultDistance() {
        return resultDistance;
    }

    public void setResultDistance(int resultDistance) {
        this.resultDistance = resultDistance;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "ResultInfo{" +
                "name='" + name + '\'' +
                ", resultDistance=" + resultDistance +
                ", time=" + time +
                '}';
    }
}
