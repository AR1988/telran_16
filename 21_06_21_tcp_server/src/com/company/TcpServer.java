package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer {

    private static final int SERVER_PORT = 3000;

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(SERVER_PORT);

        System.out.println("Server ready ...");

        Socket socket = serverSocket.accept();
        System.out.println("Connected with: " + socket.getInetAddress());

        PrintStream socketOutput = new PrintStream(socket.getOutputStream());
        BufferedReader socketInput = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        String res = socketInput.readLine();
        socketOutput.println("Hello from server: " + res);

        serverSocket.close();
    }
}
