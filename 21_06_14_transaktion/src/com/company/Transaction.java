package com.company;

public class Transaction {

    private String uuid;
    private State state;
    private long sum;

    public Transaction(String uuid, State state, long sum) {
        this.uuid = uuid;
        this.state = state;
        this.sum = sum;
    }

    public void setState(State state) {
        this.state = state;
    }

    public String getUuid() {
        return uuid;
    }

    public State getState() {
        return state;
    }

    public long getSum() {
        return sum;
    }
}
