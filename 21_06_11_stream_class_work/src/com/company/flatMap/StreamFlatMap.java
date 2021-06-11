package com.company.flatMap;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamFlatMap {
    public static void main(String[] args) {
        Model model1 = new Model("TT", 30_000);
        Model model2 = new Model("A4", 40_000);
        Model model3 = new Model("A8", 140_000);
        List<Model> modelsAudiList = Arrays.asList(model1, model2, model3);

        Model model4 = new Model("Sprinter", 20_000);
        Model model5 = new Model("C-200", 46_000);
        Model model6 = new Model("S-500", 100_000);
        List<Model> modelsMercList = Arrays.asList(model4, model5, model6);

        Auto auto1 = new Auto("Audi", modelsAudiList);
        Auto auto2 = new Auto("Merc", modelsMercList);
        List<Auto> autos = Arrays.asList(auto1, auto2);

        autos.stream()
                .flatMap(auto -> auto.getList().stream())
                .filter(model -> model.getPrice() < 50_000)
                .count();

        IntStream integerStream = IntStream.of(1, 2, 3, 4, 5);
        integerStream.flatMap(integer -> IntStream.rangeClosed(0, integer))
                .forEach(System.out::println);
    }
}

class Auto {
    private String name;
    private List<Model> list;

    public Auto(String name, List<Model> list) {
        this.name = name;
        this.list = list;
    }

    public String getName() {
        return name;
    }

    public List<Model> getList() {
        return list;
    }
}

class Model {
    private String name;
    private int price;

    public Model(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}
