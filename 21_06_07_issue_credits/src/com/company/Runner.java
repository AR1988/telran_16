package com.company;

import com.company.issuers.CreativeIssuer;
import com.company.issuers.Issuer;

import java.util.ArrayList;
import java.util.List;

public class Runner {

    private static final int CREDITS_NUMBER = 15;

    public static void main(String[] args) throws InterruptedException {
        List<Score> scores = new ArrayList<>();

        List<Thread> threads = new ArrayList<>();
        Thread th1 = new Thread(new Issuer("Maria", 100, 200, CREDITS_NUMBER, scores));
        Thread th2 = new Thread(new Issuer("Petja", 200, 300, CREDITS_NUMBER, scores));
        Thread th3 = new Thread(new CreativeIssuer("Vasjsa", 200, 300, CREDITS_NUMBER, 3, 50,
                100, 20, scores));

        threads.add(th1);
        threads.add(th2);
        threads.add(th3);

        for (Thread thread : threads) {
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        for (Score score : scores) {
            System.out.println("Name: " + score.getName() + ", Time: " + score.getTime());
        }
    }
}
