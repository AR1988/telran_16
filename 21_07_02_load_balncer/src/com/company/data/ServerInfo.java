package com.company.data;

import java.time.LocalDateTime;
import java.util.Objects;

public class ServerInfo {

    private String host;
    private int port;
    private int serverLoad;
    private final LocalDateTime lastUpdateTime;

    public ServerInfo(String host, int port, int serverLoad) {
        this.host = host;
        this.port = port;
        this.serverLoad = serverLoad;

        this.lastUpdateTime = LocalDateTime.now();
    }

    public String getHost() {
        return host;
    }

    public int getPort() {
        return port;
    }

    public int getServerLoad() {
        return serverLoad;
    }

    public LocalDateTime getLastUpdateTime() {
        return lastUpdateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ServerInfo that = (ServerInfo) o;
        return this.port == that.port && Objects.equals(this.host, that.host);
    }

    @Override
    public int hashCode() {
        return Objects.hash(host, port);
    }
}
