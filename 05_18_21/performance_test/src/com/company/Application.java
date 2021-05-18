package com.company;

import java.io.*;

public class Application {

    public static void main(String[] args) throws IOException {
//        String filePath = "text.txt";
//        readFile(filePath);
//        writeToFile(filePath);

        writeToFile();
        System.out.println(readFile());
    }

    private static void writeToFile(String filePath) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(filePath));

        String text = "text to write";
        for (int i = 0; i < 5; i++) {
            bw.write(text + "\n");
            bw.flush();
        }
        bw.close();
    }

    private static void readFile(String filePath) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(filePath));

        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
        br.close();
    }

    private static void readFileReader(String filePath) throws IOException {
        FileReader fileReader = new FileReader(filePath);

//        int charter;
//        while ((charter = fileReader.read()) != -1) {
//            System.out.println(((char) charter));
//        }
        char[] chars = new char[200];
        fileReader.read(chars);
    }

    public static void writeToFile() throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter("text.txt"));
        for (int i = 0; i < 5; i++)
            bw.write(i + " hi java\n");
        bw.close();
    }

    public static String readFile() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("text.txt"));
        StringBuilder stringBuilder = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null)
            stringBuilder.append(line + "\n");
        br.close();
        return stringBuilder.toString();
    }
}
