package com.company.hw;

public class FinishInfo {

    private String name;
    private long totalResult;

    public FinishInfo(String name, long totalResult) {
        this.name = name;
        this.totalResult = totalResult;
    }

    public FinishInfo() {
    }

    public String getName() {
        return name;
    }

    public long getTotalResult() {
        return totalResult;
    }
}
