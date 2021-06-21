package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class TcpClient {

    private static String HOST = "localhost";
    private static int SERVER_PORT = 3000;

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(HOST,SERVER_PORT);

        String toServer = "Hello";

        PrintStream socketOutput = new PrintStream(socket.getOutputStream());
        BufferedReader socketInput = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        socketOutput.println(toServer);
        String response = socketInput.readLine();

        System.out.println("Response from server: " + response);

        socket.close();
    }
}
