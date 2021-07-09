package com.example.string_operation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LineReader implements ApplicationRunner {

    @Value()
    private String filePath;
//    TODO внедрить класс StringHandle

    @Override
    public void run(ApplicationArguments args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));

        String line;
        try {
            while ((line = bufferedReader.readLine()) != null) {
//TODO отправить просченую строку на обработку (StringHandle   .handleLine(line))
            }
            System.out.println("END");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
