package com.company.adapter;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedWriterAdapter implements IPrintAdapter {

    private final BufferedWriter bufferedWriter;

    public BufferedWriterAdapter(BufferedWriter bufferedWriter) {
        this.bufferedWriter = bufferedWriter;
    }

    @Override
    public void writeLine(String text) {
        try {
            bufferedWriter.write(text);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void closeAdapterStream() {
        try {
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
