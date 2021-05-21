package com.company.adapter;

import com.company.adapter.interfaces.IReadAdapter;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStreamAdapter implements IReadAdapter {
    private FileInputStream fis;

    public FileInputStreamAdapter(String filePath) {
        try {
            this.fis = new FileInputStream(filePath);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void readLine() {
        try {
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void close() {
        try {
            fis.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
