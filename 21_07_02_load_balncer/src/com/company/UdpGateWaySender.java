package com.company;

import com.company.data.ServerInfo;
import com.company.data.Source;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UdpGateWaySender implements Runnable {

    private String gateWayHost;
    private int gateWayUdpPort;
    private Source source;

    public UdpGateWaySender(String gateWayHost, int gateWayUdpPort, Source source) {
        this.gateWayHost = gateWayHost;
        this.gateWayUdpPort = gateWayUdpPort;
        this.source = source;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep(500);

                ServerInfo serverinfo = source.getBestServerData();
                if (serverinfo == null)
                    continue;

                InetAddress address = InetAddress.getByName(gateWayHost);
                DatagramSocket udpClient = new DatagramSocket();

                String toSend = serverinfo.getHost() + ":" + serverinfo.getPort();

                byte[] outData = toSend.getBytes();
                DatagramPacket datagramPacketOut = new DatagramPacket(
                        outData,
                        outData.length,
                        address,
                        gateWayUdpPort
                );

                udpClient.send(datagramPacketOut);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
