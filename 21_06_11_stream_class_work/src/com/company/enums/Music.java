package com.company.enums;

public enum Music {

    METALL(1, "metall"),
    ROCK(5, "rock"),
    CLASSIC(4, "classic"),
    POP(3, "pop");

    private int number;
    private String name;

    Music(int number, String name) {
        this.number = number;
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }
}
