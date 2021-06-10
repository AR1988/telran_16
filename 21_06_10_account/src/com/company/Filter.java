package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Filter {

    public List<Account> filter(List<Account> accountList, Predicate<Account> predicate) {
        List<Account> resultList = new ArrayList<>();
        for (Account account : accountList)
            if (predicate.test(account))
                resultList.add(account);
        return resultList;

//        return accountList
//                .stream()
//                .filter(predicate)
//                .collect(Collectors.toList());
    }
}
