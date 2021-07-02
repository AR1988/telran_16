package com.company.data;

public class Source {

    private ServerInfo serverInfo;

    public synchronized ServerInfo getServerInfo() {
        return serverInfo;
    }

    public synchronized void updateServerInfo(ServerInfo serverInfo) {
        this.serverInfo = serverInfo;
    }
}
