package com.company;

import java.util.Collections;
import java.util.List;

public class Account {
    private String uuid;
    private long balance;
    private List<Transaction> transactions;

    public Account(String uuid, long balance, List<Transaction> transactions) {
        this.uuid = uuid;
        this.balance = balance;
        this.transactions = transactions;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public String getUuid() {
        return uuid;
    }

    public long getBalance() {
        return balance;
    }
}
