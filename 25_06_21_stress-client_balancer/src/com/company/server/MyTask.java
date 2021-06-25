package com.company.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class MyTask implements Runnable {

    private final Socket SOCKET;

    public MyTask(Socket socket) {
        this.SOCKET = socket;
    }

    @Override
    public void run() {
        try (PrintStream toClient = new PrintStream(SOCKET.getOutputStream());
             BufferedReader fromClient = new BufferedReader(new InputStreamReader(SOCKET.getInputStream()))) {
            String lineFromClient;

            while ((lineFromClient = fromClient.readLine()) != null) {
                String response = "Msg from server: " + lineFromClient;
                toClient.println(response);
            }

            String response = "Msg from server: " + lineFromClient;
            toClient.println(response);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

