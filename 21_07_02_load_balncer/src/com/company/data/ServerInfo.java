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

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public int getServerLoad() {
        return serverLoad;
    }

    public void setServerLoad(int serverLoad) {
        this.serverLoad = serverLoad;
    }

    public LocalDateTime getLastUpdateTime() {
        return lastUpdateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ServerInfo that = (ServerInfo) o;
        return port == that.port && Objects.equals(host, that.host);
    }

    @Override
    public int hashCode() {
        return Objects.hash(host, port);
    }
}
