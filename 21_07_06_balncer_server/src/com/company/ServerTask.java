package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.concurrent.atomic.AtomicInteger;

public class ServerTask implements Runnable {
    private Socket socket;
    private AtomicInteger serverLoad;

    public ServerTask(Socket socket, AtomicInteger serverLoad) {
        this.socket = socket;
        this.serverLoad = serverLoad;
    }

    @Override
    public void run() {
        try (PrintStream toClient = new PrintStream(socket.getOutputStream());
             BufferedReader fromClient = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            Thread.sleep(1500);

            String lineFromClient;

            while ((lineFromClient = fromClient.readLine()) != null) {
                String response = "Msg from server: " + lineFromClient;
                toClient.println(response);
            }

            serverLoad.decrementAndGet();

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
