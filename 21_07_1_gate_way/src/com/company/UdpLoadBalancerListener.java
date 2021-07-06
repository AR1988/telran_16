package com.company;

import com.company.data.ServerInfo;
import com.company.data.Source;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UdpLoadBalancerListener implements Runnable {

    private Source source;

    private int udpServerPort;
    private int datagramSize;

    public UdpLoadBalancerListener(Source source, int udpServerPort, int datagramSize) {
        this.source = source;
        this.udpServerPort = udpServerPort;
        this.datagramSize = datagramSize;
    }

    @Override
    public void run() {
        DatagramSocket serverUdpSocket;
        try {
            serverUdpSocket = new DatagramSocket(udpServerPort);

            byte[] dataIn = new byte[datagramSize];
            DatagramPacket paketIn = new DatagramPacket(dataIn, dataIn.length);

            while (true) {
                serverUdpSocket.receive(paketIn);
                String line = new String(dataIn, 0, paketIn.getLength());
                handleLine(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void handleLine(String line) {
        String[] lines = line.split(":");

        String serverAddress = lines[0];
        int serverPort = Integer.parseInt(lines[1]);

        ServerInfo serverInfo = new ServerInfo(serverAddress, serverPort);
        System.out.println(serverAddress + ":" + serverPort);

        source.updateServerInfo(serverInfo);
    }
}
