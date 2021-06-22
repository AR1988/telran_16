package company;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UdpServer {

    private final static int SERVER_PORT = 3001;
    private final static int DATA_SIZE = 1024;

    public static void main(String[] args) throws IOException {

        DatagramSocket serverUdpSocket = new DatagramSocket(SERVER_PORT);

        byte[] dataIn = new byte[DATA_SIZE];
        DatagramPacket paketIn = new DatagramPacket(dataIn, dataIn.length);

        serverUdpSocket.receive(paketIn);

        String result = new String(paketIn.getData(), 0, paketIn.getLength());
        System.out.println(result);
        System.out.println(paketIn.getAddress() + ":" + paketIn.getPort());

    }
}
