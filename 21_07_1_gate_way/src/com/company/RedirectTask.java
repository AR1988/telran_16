package com.company;

import com.company.data.ServerInfo;
import com.company.data.Source;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class RedirectTask implements Runnable {
    private Source source;
    private Socket clientSocket;

    public RedirectTask(Source source, Socket clientSocket) {
        this.source = source;
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        //1. Узнать адрес сервера
        ServerInfo serverInfo = source.getServerInfo();
        String host = serverInfo.getHost();
        int port = serverInfo.getPort();
        //2. Соединиться с этим сервером
        Socket socketToServer;
        try {
            socketToServer = new Socket(host, port);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        //3 перенаправление клиентских данных серверу
        try (
                PrintStream toClient = new PrintStream(clientSocket.getOutputStream());
                BufferedReader fromClient = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

                PrintStream toServer = new PrintStream(socketToServer.getOutputStream());
                BufferedReader fromServer = new BufferedReader(new InputStreamReader(socketToServer.getInputStream()));
        ) {
            String lineFromClient;
            while ((lineFromClient = fromClient.readLine()) != null) {
                //3.1 отправить данные серверу
                toServer.println(lineFromClient);
                //3.2 получим ответ от сервера
                String serverAnswer = fromServer.readLine();
                //3.3 отправит данные обратно клиенту
                toClient.println(serverAnswer);
            }
            socketToServer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
