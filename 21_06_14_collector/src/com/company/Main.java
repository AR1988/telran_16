package com.company;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<Account> accounts = Arrays.asList(
                new Account(4000, "Vajsa"),
                new Account(1500, "Petja"),
                new Account(3000, "Maria")
        );

        List<String> names = accounts.stream()
                .map(account -> account.getName())
                .collect(Collectors.toList());

        List<String> linkedListNames = accounts.stream()
                .map(account -> account.getName())
                .collect(Collectors.toCollection(() -> new LinkedList<>()));

        Set<String> setNames = accounts.stream()
                .map(account -> account.getName())
                .collect(Collectors.toSet());

        TreeSet<String> setHashNames = accounts.stream()
                .map(account -> account.getName())
                .collect(Collectors.toCollection(TreeSet::new));
    }
}
