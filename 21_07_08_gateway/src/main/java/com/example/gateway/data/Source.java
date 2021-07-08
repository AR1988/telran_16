package com.example.gateway.data;

import com.example.gateway.entity.ServerInfo;
import org.springframework.stereotype.Component;

@Component
public class Source {

    private ServerInfo serverInfo;

    public synchronized ServerInfo getServerInfo() {
        return serverInfo;
    }

    public synchronized void updateServerInfo(ServerInfo serverInfo) {
        this.serverInfo = serverInfo;
    }
}
