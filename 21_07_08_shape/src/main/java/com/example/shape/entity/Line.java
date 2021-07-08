package com.example.shape.entity;

public class Line extends Shape {

    final int length;

    public Line(char symbol, int length) {
        super(symbol);
        this.length = length;
    }

    @Override
    public void draw() {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < length; i++)
            stringBuilder.append(symbol).append(" ");

        System.out.println(stringBuilder);
    }
}
