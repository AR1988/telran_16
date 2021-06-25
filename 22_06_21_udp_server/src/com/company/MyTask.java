package com.company;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.concurrent.atomic.AtomicInteger;

public class MyTask implements Runnable {
    private DatagramPacket paketIn;
    private DatagramSocket serverUdpSocket;

    public MyTask(DatagramPacket paketIn, DatagramSocket serverUdpSocket) {
        this.paketIn = paketIn;
        this.serverUdpSocket = serverUdpSocket;
    }

    @Override
    public void run() {
        String result = new String(paketIn.getData(), 0, paketIn.getLength());
        String dataToSendBack = "message from server:  " + result.toUpperCase();

        byte[] dataOut = dataToSendBack.getBytes();
        DatagramPacket packetOut = new DatagramPacket(
                dataOut,
                dataOut.length,
                paketIn.getAddress(),
                paketIn.getPort()
        );

        try {
            serverUdpSocket.send(packetOut);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
