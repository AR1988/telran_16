package com.example.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@Configuration
@EnableAsync
public class AppConfig {

//    @Bean
//    public Executor executor(){
//    так не работает!
//        return Executors.newFixedThreadPool(5);
//    }

    @Bean
    public Executor taskExecutor(){
        return Executors.newFixedThreadPool(10);
    }
}
