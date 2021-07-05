package com.company;

import com.company.data.Source;

public class Main {
    //TODO config reader

    public static void main(String[] args) {
        Source source = new Source();

        //запуск чистилщика в отдельном потоке
        //Каждую секунду будут удаляться из списка сервера, которые не активны более 1.5 секунды
        Cleaner cleaner = new Cleaner(source, 1500);
        new Thread(cleaner).start();

        UdpServerListener udpServerListener = new UdpServerListener(3010, source);
        new Thread(udpServerListener).start();

        UdpGateWaySender udpGateWaySender = new UdpGateWaySender("localhost", 3001, source);
        new Thread(udpGateWaySender).start();
    }
}
