package com.example.shape.entity;

public abstract class Shape {
    final char symbol;

    public Shape(char symbol) {
        this.symbol = symbol;
    }

    public abstract void draw();
}
