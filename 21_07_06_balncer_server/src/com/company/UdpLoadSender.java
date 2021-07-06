package com.company;

import java.io.IOException;
import java.net.*;
import java.util.concurrent.atomic.AtomicInteger;

public class UdpLoadSender implements Runnable {

    private int udpSendDelay;
    private String balancerHost;
    private int balancerPort;
    private int serverSelfPort;
    private String serverSelfHost;
    private AtomicInteger atomicInteger;

    final String SEPARATOR = ":";

    public UdpLoadSender(int udpSendDelay,
                         String balancerHost,
                         int balancerPort,
                         int serverSelfPort,
                         String serverSelfHost,
                         AtomicInteger atomicInteger) {
        this.udpSendDelay = udpSendDelay;
        this.balancerHost = balancerHost;
        this.balancerPort = balancerPort;
        this.serverSelfPort = serverSelfPort;
        this.serverSelfHost = serverSelfHost;
        this.atomicInteger = atomicInteger;
    }

    @Override
    public void run() {
        try {
            InetAddress inetAddress = InetAddress.getByName(balancerHost);
            DatagramSocket udpSocket = new DatagramSocket();

            while (true) {
                Thread.sleep(udpSendDelay);
                String dataOut = serverSelfHost + SEPARATOR + serverSelfPort + SEPARATOR + atomicInteger.get();

                System.out.println(dataOut);

                byte[] bufferDataOut = dataOut.getBytes();
                DatagramPacket packetOut = new DatagramPacket(
                        bufferDataOut,
                        bufferDataOut.length,
                        inetAddress,
                        balancerPort
                );

                udpSocket.send(packetOut);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
