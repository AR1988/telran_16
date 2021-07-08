package com.example.shape.service;

import com.example.shape.entity.Line;
import com.example.shape.entity.Picture;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ShapeFlowService implements ApplicationRunner {

    private final List<Line> lines;
    private final Picture picture;
    private final Picture picture2;

    public ShapeFlowService(List<Line> lines, Picture picture, Picture picture2) {
        this.lines = lines;
        this.picture = picture;
        this.picture2 = picture2;
    }

    @Override
    public void run(ApplicationArguments args) {
        picture.draw();
        picture2.draw();

        lines.forEach(Line::draw);

//        for (String beanDefinitionName : applicationContext.getBeanDefinitionNames()) {
//            System.out.println(beanDefinitionName);
//        }
    }
}
