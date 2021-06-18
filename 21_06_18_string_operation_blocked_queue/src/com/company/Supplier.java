package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.BlockingQueue;

public class Supplier implements Runnable {

    private final BlockingQueue<String> source;
    private final BufferedReader br;

    public Supplier(BlockingQueue<String> source, BufferedReader br) {
        this.source = source;
        this.br = br;
    }

    @Override
    public void run() {
        String line;
        try {
            while ((line = br.readLine()) != null) {
                source.put(line);
            }
        } catch (IOException | InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}
