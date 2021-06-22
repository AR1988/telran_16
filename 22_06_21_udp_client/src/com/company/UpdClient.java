package com.company;

import java.io.IOException;
import java.net.*;

public class UpdClient {

    private final static String SERVER_HOST = "localhost";
    private final static int SERVER_PORT = 3001;

    private final static int DATA_SIZE = 1024;

    public static void main(String[] args) throws IOException {

        InetAddress address = InetAddress.getByName(SERVER_HOST);
        DatagramSocket udpClient = new DatagramSocket(1555);

        String toSend = "Hello";
        byte[] outData = toSend.getBytes();
        DatagramPacket datagramPacketOut = new DatagramPacket(
                outData,
                outData.length,
                address,
                SERVER_PORT
        );

        udpClient.send(datagramPacketOut);
        udpClient.close();
    }
}
