package com.example.gateway.service;

import com.example.gateway.data.Source;
import com.example.gateway.entity.ServerInfo;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

@Component
public class RedirectTask {

    private final Source source;

    public RedirectTask(Source source) {
        this.source = source;
    }

    @Async
    public void handleConnection(Socket clientSocket) {
        System.out.println("new connection, thread: " + Thread.currentThread().getName());

        ServerInfo serverInfo = source.getServerInfo();
        String host = serverInfo.getHost();
        int port = serverInfo.getPort();

        Socket socketToServer;
        try {
            socketToServer = new Socket(host, port);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        try (
                PrintStream toClient = new PrintStream(clientSocket.getOutputStream());
                BufferedReader fromClient = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

                PrintStream toServer = new PrintStream(socketToServer.getOutputStream());
                BufferedReader fromServer = new BufferedReader(new InputStreamReader(socketToServer.getInputStream()))
        ) {
            String lineFromClient;
            while ((lineFromClient = fromClient.readLine()) != null) {
                toServer.println(lineFromClient);
                String serverAnswer = fromServer.readLine();
                toClient.println(serverAnswer);
            }
            socketToServer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
