package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        BlockingQueue<String> source = new LinkedBlockingQueue<>();
        Thread readerThread = new Thread(new MessageReader(source));
//
//        Thread printerThread1 = new Thread(new MessagePrinter(source));
//        Thread printerThread2 = new Thread(new MessagePrinter(source));
//        Thread printerThread3 = new Thread(new MessagePrinter(source));
//        Thread printerThread4 = new Thread(new MessagePrinter(source));
//        Thread printerThread5 = new Thread(new MessagePrinter(source));
//
        readerThread.start();
//        printerThread1.start();
//        printerThread2.start();
//        printerThread3.start();
//        printerThread4.start();
//        printerThread5.start();

        ExecutorService service = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            service.execute(new MessagePrinter(source));
        }
//        List<Thread> threads = new ArrayList<>();
//        for (int i = 0; i < 15_000; i++) {
//            threads.add(new Thread(new MessagePrinter(source)));
//        }
//
//        for (int i = 0; i < 10; i++) {
//            threads.get(i).start();
//        }
//        for (int i = 0; i < 10; i++) {
//            threads.get(i).join();
//        }
//
//        for (int i = 10; i < 20; i++) {
//            threads.get(i).start();
//        }
//        for (int i = 10; i < 20; i++) {
//            threads.get(i).join();
//        }
    }
}
