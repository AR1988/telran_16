package com.company;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {

//        String filePath = "resources/text.txt";
//        readFile(filePath);
        writeToFile("text1231.txt");
    }

    public static void readFile(String filePath) throws IOException {
        FileInputStream readStream = new FileInputStream(filePath);

        int byteId;
        StringBuilder stringBuilder = new StringBuilder();
        while ((byteId = readStream.read()) != -1) {
//            System.out.print(byteId);
//            System.out.println(" " + ((char) byteId));
            stringBuilder.append(((char) byteId));
        }
        System.out.println(stringBuilder);
        readStream.close();

        readStream = new FileInputStream(filePath);

        int size = readStream.available();
        byte[] buffer = new byte[size];
        readStream.read(buffer);

        for (byte b : buffer) {
            System.out.println(((char) b));
        }
        System.out.println(Arrays.toString(buffer));
    }

    public static void writeToFile(String filName) throws IOException {

        FileOutputStream fileOutputStream = new FileOutputStream(filName);

//        FileOutputStream fileOutputStream = new FileOutputStream(filName, true);

        String text = "hi file,\n i am Java.";

        byte[] toWrite = text.getBytes();
        fileOutputStream.write(toWrite);

        fileOutputStream.close();
    }
}
