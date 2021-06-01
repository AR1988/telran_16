package com.company;


import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Main {

    public static void main(String[] args) {

        System.out.println("hi");
        System.out.println("word");
        Thread thClock = new Thread(new Clock());
        thClock.setDaemon(true);
        thClock.start();

        Thread thTimer = new Timer(5);
        thTimer.start();

        Thread.currentThread().setName("App");
        System.out.println(Thread.currentThread().getName());

        System.out.println("word1");
        System.out.println("word2");

        while (true) {
            System.out.println(LocalTime.now().format(DateTimeFormatter.ofPattern("ss")));
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
