package com.company.data;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Source {

    List<ServerInfo> source = new ArrayList<>();

    public synchronized ServerInfo getBestServerData() {
        return source
                .stream()
                .min(Comparator.comparingInt(ServerInfo::getServerLoad))
                .orElse(null);
    }

    public synchronized void updateServerInfo(ServerInfo serverInfo) {
        source.remove(serverInfo);
        source.add(serverInfo);

        System.out.println(source.size());
        System.out.println(source);
    }

    public void removeUnused(int millis) {
        //удалить объекты из списка, которые обновлялись последний раз больше чем (millis) мс назад
        source.removeIf(serverInfo ->
                ChronoUnit.MILLIS.between(serverInfo.getLastUpdateTime(), LocalDateTime.now()) > millis);
    }
}
