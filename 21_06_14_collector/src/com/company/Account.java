package com.company;

public class Account {
    private long balance;
    private String name;

    public Account(long balance, String name) {
        this.balance = balance;
        this.name = name;
    }

    public long getBalance() {
        return balance;
    }

    public String getName() {
        return name;
    }
}
