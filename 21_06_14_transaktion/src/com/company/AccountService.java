package com.company;

import java.util.List;

public class AccountService {
    //Напишите метод ,
    //использующий stream, который вычислит общую сумму в размере погашенных(Cancelled)
    //сделок для всех непустых счетов ( balance > 0 ).

    public long getSumAllCancelledTransactions(List<Account> accounts) {

//        Long acc = 0L;
//        for (Account account : accounts) {
//            if (account.getBalance() > 0) {
//                for (Transaction transaction : account.getTransactions()) {
//                    if (transaction.getState().equals(State.CANCELLED)) {
//                        Long sum = transaction.getSum();
//                        acc = acc + sum;
//                    }
//                }
//            }
//        }

//        return accounts
//                .stream()
//                .filter(account -> account.getBalance() > 0)
//                .flatMap(account -> account.getTransactions().stream())
//                .filter(transaction -> transaction.getState().equals(State.FINISHED))
//                .map(transaction -> transaction.getSum())
//                .reduce(0L, (res, elt) -> res + elt);

        return accounts
                .stream()
                .filter(account -> account.getBalance() > 0)
                .flatMap(account -> account.getTransactions().stream())
                .filter(transaction -> transaction.getState().equals(State.FINISHED))
                .map(transaction -> transaction.getSum())
                .reduce(0L, (res, elt) -> res + elt);
    }
}
