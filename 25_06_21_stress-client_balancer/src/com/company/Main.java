package com.company;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    //количесвто потоков для executor'a
    private static final int THREAD_POOL = 20;
    //кол-во соеденений с сервером
    private static final int CONNECTIONS_NUMBER = 2_00;
    //кол-во сообщений для отправки на сервер для одного соеденения
    private static final int MESSAGE_PER_CONNECTION = 1_000;
    //сообщение
    private static final String MESSAGE = "Hello world";

    //GateWay адрес
    private static final String GATEWAY_HOST = "localhost";
    private static final int GATEWAY_PORT = 3_001;


    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL);

        for (int i = 0; i < CONNECTIONS_NUMBER; i++) {
            Thread.sleep(100);
            executorService.execute(new ConnectionTask(GATEWAY_HOST, GATEWAY_PORT, MESSAGE_PER_CONNECTION, MESSAGE));
        }

        executorService.shutdown();
        executorService.awaitTermination(10, TimeUnit.SECONDS);
    }
}
