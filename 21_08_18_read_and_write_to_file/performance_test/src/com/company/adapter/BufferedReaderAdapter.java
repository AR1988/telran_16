package com.company.adapter;

import com.company.adapter.interfaces.IReadAdapter;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReaderAdapter implements IReadAdapter {
    private BufferedReader br;

    public BufferedReaderAdapter(String filePath) {
        try {
            this.br = new BufferedReader(new FileReader(filePath));
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void readLine() {
        try {
            String line;
            while ((line = br.readLine()) != null) {
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void close() {
        try {
            br.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
