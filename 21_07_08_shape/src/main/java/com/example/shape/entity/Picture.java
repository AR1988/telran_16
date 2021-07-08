package com.example.shape.entity;

import java.util.List;

public class Picture extends Shape {

    private final List<Shape> shapes;

    public Picture(char symbol, List<Shape> shapes) {
        super(symbol);
        this.shapes = shapes;
    }

    @Override
    public void draw() {
        Line line = new Line(symbol, 25);
        line.draw();

//        shapes.forEach(shape -> shape.draw());
        shapes.forEach(Shape::draw);

        line.draw();
    }
}
