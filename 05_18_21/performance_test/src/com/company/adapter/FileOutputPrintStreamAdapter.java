package com.company.adapter;

import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputPrintStreamAdapter implements IPrintAdapter {

    private final FileOutputStream fileOutputStream;

    public FileOutputPrintStreamAdapter(FileOutputStream fileOutputStream) {
        this.fileOutputStream = fileOutputStream;
    }

    @Override
    public void writeLine(String text) {
        try {
            byte[] bytes = text.getBytes();
            fileOutputStream.write(bytes);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void closeAdapterStream() {
        try {
            fileOutputStream.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
