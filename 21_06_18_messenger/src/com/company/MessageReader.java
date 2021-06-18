package com.company;

import java.util.Scanner;
import java.util.concurrent.BlockingQueue;

public class MessageReader implements Runnable {
    private BlockingQueue<String> SOURCE;

    public MessageReader(BlockingQueue<String> SOURCE) {
        this.SOURCE = SOURCE;
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                String message = scanner.nextLine();
                SOURCE.put(message);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
