package com.example.shape.config;

import com.example.shape.entity.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class AppConfig {

    @Bean("line_+")
    @Qualifier("pic_1")
    public Line line1() {
        return new Line('+', 33);
    }

    @Bean("line_*")
    @Qualifier("pic_2")
    public Line line2() {
        return new Line('*', 33);
    }

    @Bean
    @Qualifier("pic_1")
    public Line line3() {
        return new Line('-', 33);
    }

    @Bean
    @Qualifier("pic_1")
    public Rectangle rectangle() {
        return new Rectangle('#', 10, 15);
    }

    @Bean
    @Qualifier("pic_2")
    public Rectangle rectangle2() {
        return new Rectangle('1', 10, 15);
    }

    @Bean
    public Picture picture(@Qualifier("pic_1") List<Shape> shapes) {
//        return new Picture('=', Arrays.asList(rectangle(), line2()));
        return new Picture('=', shapes);
    }

    @Bean
    public Picture picture2(@Qualifier("pic_2") List<Shape> shapes) {
        return new Picture('=', shapes);
    }
}
