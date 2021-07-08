package com.example.gateway.service;

import com.example.gateway.data.Source;
import com.example.gateway.entity.ServerInfo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

@Component
public class UdpLoadBalancerListener {

    private Source source;

    private int udpServerPort;
    private int datagramSize;

    public UdpLoadBalancerListener(Source source,
                                   @Value("${udp.port.server}") int udpServerPort,
                                   @Value("${datagram.size}") int datagramSize) {
        this.source = source;
        this.udpServerPort = udpServerPort;
        this.datagramSize = datagramSize;
    }

    @Async
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
