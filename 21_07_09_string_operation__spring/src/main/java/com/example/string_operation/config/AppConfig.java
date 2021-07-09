package com.example.string_operation.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@Configuration
@EnableAsync
public class AppConfig {
    @Value("${output.file}")
    private String outputFile;

    @Bean
    public PrintWriter printWriter() throws FileNotFoundException {
//        return new PrintWriter(outputFile);
        return new PrintWriter(new FileOutputStream(outputFile));
    }

    @Bean
    public Executor taskExecutor() {
        return Executors.newFixedThreadPool(1);
    }
}
