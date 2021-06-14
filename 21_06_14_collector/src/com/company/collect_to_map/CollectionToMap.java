package com.company.collect_to_map;

import com.company.Account;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CollectionToMap {
    public static void main(String[] args) {
        List<Account> accounts = Arrays.asList(
                new Account(4000, "Vajsa"),
                new Account(1500, "Petja"),
                new Account(3000, "Maria")
        );

        Map<String, Long> map = accounts
                .stream()
                .collect(Collectors.toMap(account -> account.getName(), account1 -> account1.getBalance()));
        System.out.println(map);
    }
}
