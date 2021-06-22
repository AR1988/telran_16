package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class TcpClient {

    private static String HOST = "localhost";
    private static int SERVER_PORT = 3000;

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(HOST, SERVER_PORT);

        PrintStream socketOutput = new PrintStream(socket.getOutputStream());
        BufferedReader socketInput = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        Scanner scanner = new Scanner(System.in);

        String lineFormConsole;
        while ((lineFormConsole = scanner.nextLine()) != null && !lineFormConsole.equals("exit")) {
            socketOutput.println(lineFormConsole);
            String response = socketInput.readLine();
            System.out.println("Response from server: " + response);
        }
        socket.close();
    }
}
