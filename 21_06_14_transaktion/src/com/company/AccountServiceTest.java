package com.company;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class AccountServiceTest {
    List<Account> accounts;
    AccountService accountService = new AccountService();

    @Before
    public void init() {
        Transaction transaction1 = new Transaction("1", State.FINISHED, 50_000);
        Transaction transaction2 = new Transaction("2", State.FINISHED, 30_000);
        Transaction transaction3 = new Transaction("3", State.FINISHED, 20_000);
        Transaction transaction9 = new Transaction("9", State.CANCELLED, 27_000);
        Transaction transaction10 = new Transaction("10", State.CANCELLED, 10_000);
        List<Transaction> transactionsFinished1 = Arrays.asList(transaction1, transaction2, transaction3, transaction10, transaction9);

        Transaction transaction4 = new Transaction("4", State.FINISHED, 40_000);
        Transaction transaction5 = new Transaction("5", State.CANCELLED, 70_000);
        Transaction transaction6 = new Transaction("6", State.FINISHED, 30_000);
        Transaction transaction7 = new Transaction("7", State.CANCELLED, 32_000);
        Transaction transaction8 = new Transaction("8", State.FINISHED, 35_000);
        List<Transaction> transactionsFinished2 = Arrays.asList(transaction4, transaction5, transaction6, transaction7, transaction8);

        Account account1 = new Account("0101", 10_000, transactionsFinished1);
        Account account2 = new Account("0202", 20_000, transactionsFinished2);

        accounts = Arrays.asList(account1, account2);

    }

    @Test
    public void getSumAllCancelledTransactions() {
        long res = accountService.getSumAllCancelledTransactions(accounts);
        System.out.println(res);
    }
}
