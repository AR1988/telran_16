package com.example.gateway.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

@Component
public class TcpOuterListener {

    @Value("${tcp.port.server}")
    private int tcpPort;

    private final RedirectTask redirectTask;

    public TcpOuterListener(RedirectTask redirectTask) {
        this.redirectTask = redirectTask;
    }

    @Async
    public void run() throws IOException {
        ServerSocket serverSocket = new ServerSocket(tcpPort);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("new connection");
            redirectTask.handleConnection(socket);
        }
    }
}
