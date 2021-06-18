package com.company;

import java.util.concurrent.BlockingQueue;

public class MessagePrinter implements Runnable {
    private final BlockingQueue<String> SOURCE;

    public MessagePrinter(BlockingQueue<String> source) {
        this.SOURCE = source;
    }

    @Override
    public void run() {
//        while (source.size() != 6) {
//            continue;
//        }

        while (true) {
            try {
//                System.out.println("print thread: " + Thread.currentThread().getName());
//                System.out.println("source size: " + source.size());
                String message = SOURCE.take();
                System.out.println("thread print to message " + Thread.currentThread().getName() + " message: " + message);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
