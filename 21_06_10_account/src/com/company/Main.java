package com.company;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {
        List<Account> accountList = Arrays.asList(
                new Account("Vasja", 40_000, false),
                new Account("Max", 30_000, false),
                new Account("Petja", 50_000, false),

                new Account("Erich", -10_000, false),
                new Account("Maria", -10_000, false),
                new Account("Domionik", -10_000, true),

                new Account("Felix", 150_000, false),
                new Account("Tanja", 120_000, false),
                new Account("Vovan", 150_000, true)
        );

        Predicate<Account> predicate1 = account -> account.getBalance() > 0;
        Predicate<Account> predicate2 = account -> account.getBalance() > 100_000 && !account.isLocked();

        Predicate<Account> predicateIsLocked = account -> account.isLocked();
        Predicate<Account> predicateIsLockedAndBalanceMoreThen0 = predicate1.and(predicateIsLocked);

        Filter filter = new Filter();
        List<Account> listByFilter1 = filter.filter(accountList, predicate1);
        List<Account> listByFilter2 = filter.filter(accountList, predicate2);
        List<Account> listByFilter3 = filter.filter(accountList, predicateIsLockedAndBalanceMoreThen0);

        System.out.println(accountList);
        System.out.println(listByFilter1);
        System.out.println(listByFilter2);
        System.out.println(listByFilter3);
    }
}
