package com.company;

import com.company.data.Source;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TcpOuterListener implements Runnable {

    private Source source;

    private int serverPort;
    private int threadPool;

    public TcpOuterListener(Source source, int serverPort, int threadPool) {
        this.source = source;
        this.serverPort = serverPort;
        this.threadPool = threadPool;
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

        ExecutorService executorService = Executors.newFixedThreadPool(threadPool);
        while (true) {
            try {
                Socket clientSocket = serverSocket.accept();
                System.out.println("new connection");
                executorService.execute(new RedirectTask(source, clientSocket));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
