package com.company;

public class Score {

    private String name;
    private long time;

    public Score(String name, long time) {
        this.name = name;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public long getTime() {
        return time;
    }
}
