package com.company;

import com.company.data.Source;

public class Cleaner implements Runnable {

    private final Source source;
    private final int periodMillis;

    public Cleaner(Source source, int periodMillis) {
        this.source = source;
        this.periodMillis = periodMillis;
    }

    @Override
    public void run() {
        //каждые (periodMillis) мс запускать удаление из списка не активных серверов (...removeUnused(periodMillis))
        while (true) {
            try {
                Thread.sleep(periodMillis);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            source.removeUnused(periodMillis);
        }
    }
}
