package com.company.data;

import java.util.ArrayList;
import java.util.List;

public class Source {

    List<ServerInfo> source = new ArrayList<>();

    public synchronized ServerInfo getBestServerData() {
        return source
                .stream()
                .
                //найти из списка лучший сервер (по полю загружености) и вернуть его. Используйте Comparator;
    }

    public synchronized void updateServerInfo(ServerInfo serverInfo) {
        source.remove(serverInfo);
        source.add(serverInfo);
    }

    public void removeUnused(int millis) {
        //удалить объекты из списка, которые обновлялись последний раз больше чем (millis) мс назад
        source.removeIf(//some predicate here);
    }
}
