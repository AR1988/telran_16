package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class ConnectionTask implements Runnable {

    private String gateWayHost;
    private int gateWayPort;
    //кол-во сообщений для отправки на сервер для одного соеденения
    private int messagePerConnection;
    //сообщение
    private String messageToSend;

    public ConnectionTask(String gateWayHost, int gateWayPort, int messagePerConnection, String messageToSend) {
        this.gateWayHost = gateWayHost;
        this.gateWayPort = gateWayPort;
        this.messagePerConnection = messagePerConnection;
        this.messageToSend = messageToSend;
    }

    @Override
    public void run() {
        Socket socket;
        try {
            socket = new Socket(gateWayHost, gateWayPort);
        } catch (IOException e) {
            System.err.println(e.getMessage());
            return;
        }

        try (BufferedReader fromGateway = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintStream toGateway = new PrintStream(socket.getOutputStream())) {

            //отправляем сообщения и получаем ответ <messagePerConnection> раз
            for (int i = 0; i < messagePerConnection; i++) {
                //отправить сообщение
                toGateway.println(messageToSend);
                //получаем и записываем ответ сервера в responseMsg
                String responseMsg = fromGateway.readLine();
                System.out.println(responseMsg);
            }
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println(e.getMessage());
        }
    }
}
