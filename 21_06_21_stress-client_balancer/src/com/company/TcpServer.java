package com.company;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TcpServer {

    private static final int SERVER_PORT = 3000;

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(SERVER_PORT);
        System.out.println("Server ready ...");
        ExecutorService executor = Executors.newFixedThreadPool(5);

        while (true) {
            System.out.println("Ready to new connection");
            Socket socket = serverSocket.accept();
            executor.execute(new MyTask(socket));
        }
    }
}
