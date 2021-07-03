package com.company;

import com.company.data.ServerInfo;
import com.company.data.Source;

public class UdpServerListener implements Runnable {

    private int udpPort;
    private Source source;

    int dataSize = 1024;

    @Override
    public void run() {
        // TODO принимать по порту 3010 пакеты от серверов.
        // записысывать данные о сервере в нашу структуру дыннах (Source)
    }

    private void handleLine(String line) {
//        ServerInfo serverInfo = new ServerInfo(address, port, serverLoad);
//        source.updateServerInfo(serverInfo);
    }
}
