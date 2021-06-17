package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

public class Supplier implements Runnable {

    private final List<String> source;
    private final BufferedReader br;

    public Supplier(List<String> source, BufferedReader br) {
        this.source = source;
        this.br = br;
    }

    @Override
    public void run() {
        String line;

        try {
            while ((line = br.readLine()) != null) {
                source.add(line);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
