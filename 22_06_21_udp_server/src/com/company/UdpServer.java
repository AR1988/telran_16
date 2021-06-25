package com.company;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class UdpServer {

    private final static String PROPS_FILE_NAME = "src/config/application.props";

    public static void main(String[] args) throws IOException {
        //init config
        String propsFile = args.length > 0 ? args[0] : PROPS_FILE_NAME;
        ConfigReader configReader = new ConfigReader(propsFile);
        int serverPort = Integer.parseInt(configReader.getProperty("server_port"));
        int dataSize = Integer.parseInt(configReader.getProperty("data_size"));
        //...
        DatagramSocket serverUdpSocket = new DatagramSocket(serverPort);
        System.out.println("Server started on port:");

        byte[] dataIn = new byte[dataSize];
        DatagramPacket paketIn = new DatagramPacket(dataIn, dataIn.length);

        ExecutorService executorService = Executors.newFixedThreadPool(5);

        while (true) {
            System.out.println("Waiting for new packages");
            serverUdpSocket.receive(paketIn);
            System.out.println("New package receive from: " + paketIn.getAddress() + ":" + paketIn.getPort());
            executorService.execute(new MyTask(paketIn, serverUdpSocket));
        }
    }
}
