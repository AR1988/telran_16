package com.company;

import com.company.data.Source;
import com.company.helpers.ConfigReader;

import java.io.IOException;

public class Main {

    static final String CONFIG_PATH_DEFAULT = "config/application.props";

    public static void main(String[] args) throws IOException {
        String configPath = args.length == 1 ? args[0] : CONFIG_PATH_DEFAULT;
        ConfigReader configReader = new ConfigReader(configPath);

        int tcpServerPort = Integer.parseInt(configReader.getProp("tcp.port.server"));
        int udpServerPort = Integer.parseInt(configReader.getProp("udp.port.server"));
        int dataGramSize = Integer.parseInt(configReader.getProp("datagram.size"));
        int threads = Integer.parseInt(configReader.getProp("thread.pool"));

        Source source = new Source();

        Thread udpBalancerListenerThread = new Thread(new UdpLoadBalancerListener(source, udpServerPort, dataGramSize));
        udpBalancerListenerThread.start();

        Thread tcpOuterListenerThread = new Thread(new TcpOuterListener(source, tcpServerPort, threads));
        tcpOuterListenerThread.start();
    }
}
