package com.company;

import java.io.IOException;
import java.net.*;

public class UpdClient {

    private final static String PROPS_FILE_NAME = "src/config/application.props";

    public static void main(String[] args) throws IOException, InterruptedException {
        //init config
        String propsFile = args.length > 0 ? args[0] : PROPS_FILE_NAME;
        ConfigReader configReader = new ConfigReader(propsFile);
        String serverHost = configReader.getProperty("server_host");
        int serverPort = Integer.parseInt(configReader.getProperty("server_port"));
        int dataSize = Integer.parseInt(configReader.getProperty("data_size"));
        //...
        InetAddress address = InetAddress.getByName(serverHost);
        DatagramSocket udpClient = new DatagramSocket();

        String toSend = "Hello";

        byte[] outData = toSend.getBytes();
        DatagramPacket datagramPacketOut = new DatagramPacket(
                outData,
                outData.length,
                address,
                serverPort
        );

        while (true) {
            //send message
            Thread.sleep(1500);
            udpClient.send(datagramPacketOut);

            byte[] dataIn = new byte[dataSize];
            DatagramPacket paketIn = new DatagramPacket(dataIn, dataSize);
            //waiting answer
            udpClient.receive(paketIn);
            System.out.println(new String(dataIn, 0, paketIn.getLength()));
        }
    }
}
