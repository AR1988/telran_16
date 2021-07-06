package com.company;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    private static final String DEFAULT_PROPS_PATH = "config/application.props";

    public static void main(String[] args) throws IOException {
        int selfPort = Integer.parseInt(args[0]);
        String propsPath = args.length > 1 ? args[1] : DEFAULT_PROPS_PATH;

        ConfigReader configReader = new ConfigReader(propsPath);
        String balancerHost = configReader.getProperty("balancer.host");
        int balancerPort = Integer.parseInt(configReader.getProperty("udp.balancer.port"));
        int interval = Integer.parseInt(configReader.getProperty("load.time.interval"));
        int threads = Integer.parseInt(configReader.getProperty("threads"));

        AtomicInteger serverLoad = new AtomicInteger();

        UdpLoadSender udpLoadSender = new UdpLoadSender(
                interval,
                balancerHost,
                balancerPort,
                selfPort,
                balancerHost,
                serverLoad
        );
        new Thread(udpLoadSender).start();

        TcpGateWayListener tcpGateWayListener = new TcpGateWayListener(selfPort, threads, serverLoad);
        new Thread(tcpGateWayListener).start();
    }
}
