package com.company;

import com.company.data.Source;

public class UdpGateWaySender implements Runnable {

    private String gateWayHost;
    private int gateWayUdpPort;
    private Source source;

    private int dataSize = 1024;

    public UdpGateWaySender(String gateWayHost, int gateWayUdpPort, Source source) {
        this.gateWayHost = gateWayHost;
        this.gateWayUdpPort = gateWayUdpPort;
        this.source = source;
    }

    @Override
    public void run() {
        //TODO каждыйе 500мс отправлять пакеты с данными о сервере нашему GW по UDP

        //Thread.sleep(500);
        //send(source.getServerInfo());
    }
}
