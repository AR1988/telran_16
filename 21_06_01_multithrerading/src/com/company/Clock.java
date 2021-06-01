package com.company;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Clock implements Runnable {

    @Override
    public void run() {
        while (true) {
            System.out.println(LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
