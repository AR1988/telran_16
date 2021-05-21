package com.company;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class Application {

    public static void main(String[] args) throws FileNotFoundException {
        printWriter();
    }

    public static void printWriter() throws FileNotFoundException {
//        FileOutputStream fileOutputStream = new FileOutputStream("text_pw_02.txt");
//        PrintWriter pw = new PrintWriter(fileOutputStream);
//        PrintWriter pw = new PrintWriter(System.out);
        PrintWriter pw = new PrintWriter("text_pw_02.txt");

        pw.println("string 1");
        pw.println("string 2");
        pw.flush();

        pw.print("string 3");
        pw.println(" string 3_1");
        pw.println("string 4");
        pw.close();
    }
}
