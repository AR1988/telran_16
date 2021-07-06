package com.company;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class TcpGateWayListener implements Runnable {

    private int serverPort;
    private int threads;
    private AtomicInteger serverLoad;

    public TcpGateWayListener(int serverPort, int threads, AtomicInteger serverLoad) {
        this.serverPort = serverPort;
        this.threads = threads;
        this.serverLoad = serverLoad;
    }

    @Override
    public void run() {
        ServerSocket serverSocket;
        try {
            serverSocket = new ServerSocket(serverPort);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        ExecutorService executor = Executors.newFixedThreadPool(threads);

        while (true) {
            try {
                Socket socket = serverSocket.accept();
                serverLoad.incrementAndGet();
                executor.execute(new ServerTask(socket, serverLoad));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
