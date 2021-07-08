package com.example.shape.entity;

public class Rectangle extends Shape {

    final int height;
    final int width;

    public Rectangle(char symbol, int height, int width) {
        super(symbol);
        this.height = height;
        this.width = width;
    }

    @Override
    public void draw() {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {

                if (i == 0 || i == height - 1)
                    stringBuilder.append(symbol);
                else if (j == 0 || j == width - 1)
                    stringBuilder.append(symbol);
                else
                    stringBuilder.append(" ");

            }
            stringBuilder.append("\n");
        }

//        for (int i = 0; i < height; i++) {
//            for (int j = 0; j < width; j++) {
//                if (i == 0 || j == 0 || i == height - 1 || j == width - 1)
//                    System.out.print(symbol);
//                else System.out.print(" ");
//            }
//            System.out.println();
//        }

        System.out.println(stringBuilder);
    }
}
