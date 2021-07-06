package com.company;

import com.company.data.Source;

import java.io.IOException;

public class Main {

    private static final String DEFAULT_PROPS_PATH = "config/application.props";

    public static void main(String[] args) throws IOException {
        String propsPath = args.length > 0 ? args[0] : DEFAULT_PROPS_PATH;

        ConfigReader properties = new ConfigReader(propsPath);

        int udpServerPort = Integer.parseInt(properties.getProperty("udp.balancer.port"));
        int clearDelay = Integer.parseInt(properties.getProperty("clear.delay"));
        int gateWayPort = Integer.parseInt(properties.getProperty("udp.gateway.port"));
        String gateWayHost = properties.getProperty("gateway.host");

        Source source = new Source();

        Cleaner cleaner = new Cleaner(source, clearDelay);
        new Thread(cleaner).start();

        UdpServerListener udpServerListener = new UdpServerListener(udpServerPort, source);
        new Thread(udpServerListener).start();

        UdpGateWaySender udpGateWaySender = new UdpGateWaySender(gateWayHost, gateWayPort, source);
        new Thread(udpGateWaySender).start();
    }
}
