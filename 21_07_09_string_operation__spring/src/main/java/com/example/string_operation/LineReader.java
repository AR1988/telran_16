package com.example.string_operation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@Component
public class LineReader implements ApplicationRunner {

    @Value("${input.file}")
    private String filePath;
    private final StringHandle stringHandle;

    public LineReader(StringHandle stringHandle) {
        this.stringHandle = stringHandle;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));

        String line;
        try {
            while ((line = bufferedReader.readLine()) != null) {
                stringHandle.handleLine(line);
            }

            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
