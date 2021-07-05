package com.company;

import com.company.data.ServerInfo;
import com.company.data.Source;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UdpServerListener implements Runnable {

    private int udpPort;
    private Source source;
    private final String SEPARATOR = ":";

    private final int DATA_SIZE = 1024;

    public UdpServerListener(int udpPort, Source source) {
        this.udpPort = udpPort;
        this.source = source;
    }

    @Override
    public void run() {
        try {
            DatagramSocket updSocket = new DatagramSocket(udpPort);

            byte[] bufferPaketIn = new byte[DATA_SIZE];
            DatagramPacket packetIn = new DatagramPacket(bufferPaketIn, DATA_SIZE);
            while (true) {
                updSocket.receive(packetIn);
                String dataIn = new String(packetIn.getData(), 0, packetIn.getLength());
                handleLine(dataIn);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void handleLine(String line) {
        //localhost:4200:32
        String[] serverData = line.split(SEPARATOR);

        String address = serverData[0];
        int port = Integer.parseInt(serverData[1]);
        int serverLoad = Integer.parseInt(serverData[2]);

        ServerInfo serverInfo = new ServerInfo(address, port, serverLoad);
        source.updateServerInfo(serverInfo);
    }
}
