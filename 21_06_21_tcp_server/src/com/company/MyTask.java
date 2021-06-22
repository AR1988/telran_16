package com.company;

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
        System.out.println("Connected with: " + SOCKET.getInetAddress());
        System.out.println("Thread name: " + Thread.currentThread().getName());
        while (true) {
            try {
                PrintStream socketOutput = new PrintStream(SOCKET.getOutputStream());
                BufferedReader socketInput = new BufferedReader(new InputStreamReader(SOCKET.getInputStream()));

                if (socketInput.readLine().equals("exit"))
                    break;
                String res = socketInput.readLine();

                socketOutput.println("Hello from server: " + res);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
