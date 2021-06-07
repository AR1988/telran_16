package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.*;

public class Main {

//    Functions<T,R> accept arguments and produce results.
//    Operators produce results of the same type as their arguments (special case of function).
//    Predicates return boolean values and accept any arguments (boolean-valued function).
//    Suppliers return values and accept nothing.
//    Consumers accept arguments and return no result.

    public static void main(String[] args) {
//        function();
//        predicate();
//        suppliers();
//        consumer();
//        unaryOperation();
        binaryOperator();
    }

    //UnaryOperator<T>
//UnaryOperator<T> принимает в качестве параметра объект типа T,
//выполняет над ними операции и возвращает результат операций в виде объекта типа T:
    private static void unaryOperation() {
        UnaryOperator<Integer> integerUnaryOperator = (x) -> x * x + 1;
        System.out.println(integerUnaryOperator.apply(2));
    }

//    public Integer apply(Integer integer) {
//        return integer * integer + 1;
//    }

    //Consumer<T>
//Consumer<T> выполняет некоторое действие над объектом типа T, при этом ничего не возвращая:
    private static void consumer() {
        Consumer<User> consumer = user -> System.out.println(user.name + " " + user.lastName);
        User user = new User("user", "Pupkin");
        consumer.accept(user);

        Consumer<User> doubleConsumer = user1 -> {
            user1.name = "Patja";
            System.out.println(user1.name + " " + user1.lastName);
        };
        doubleConsumer.accept(user);
        System.out.println(user.name + " " + user.lastName);
    }

    //Supplier<T>
//Supplier<T> не принимает никаких аргументов, но должен возвращать объект типа T:
    private static void suppliers() {
        Supplier<User> userFactory = () -> {
            Scanner scanner = new Scanner(System.in);
            String name = scanner.nextLine();
            String lastName = scanner.nextLine();
            return new User(name, lastName);
        };

        User user = userFactory.get();
        System.out.println(user.name + " lastName: " + user.lastName);

        Supplier<User> supplier2 = () -> new User("user", "bla");
        System.out.println(supplier2.get().name + " lastName: " + supplier2.get().lastName);
    }

    public static void function() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("th_2");
            }
        });
        Thread threadL = new Thread(() -> System.out.println("th_1"));
        thread.start();
        threadL.start();
//
//        () -> System.out.println();
//        () -> {
//            for (int i = 0; i < 2; i++) {
//                System.out.println("i " + i);
//            }
//        };

//
        Function<String, Long> converter = (str) -> Long.parseLong(str) + 15;
        Long result = converter.apply("555");
        System.out.println(result);
//        The same
        System.out.println(converterToLong("555"));
    }

    //Predicate<T>
//Функциональный интерфейс Predicate<T> проверяет соблюдение некоторого условия.
//Если оно соблюдается, то возвращается значение true. В качестве параметра лямбда-выражение принимает объект типа T
    public static void predicate() {
        Predicate<Integer> predicate1 = x -> x % 2 == 0;
        System.out.println(predicate1.test(5));
        System.out.println(predicate1.test(2));
        System.out.println(predicate1.test(4));
        System.out.println(predicate1.test(7));

        CustomPredicate<Integer> customPredicate = (x, y, z) -> x != y && y != z && z != x;
        System.out.println(customPredicate.test(1, 5, 6));
        System.out.println(customPredicate.test(5, 5, 5));
    }

    public static Long converterToLong(String str) {
        return Long.parseLong(str) + 15;
    }

    //BinaryOperator<T>
//BinaryOperator<T> принимает в качестве параметра два объекта типа T
//выполняет над ними бинарную операцию и возвращает ее результат также в виде объекта типа T:
    public static void binaryOperator() {
        BinaryOperator<Integer> binaryOperator = (x, y) -> x + y;
        System.out.println(binaryOperator.apply(5, 5));

        BiFunction<Integer, String, Double> function = (x, y) -> Double.valueOf(x + Integer.valueOf(y));
        System.out.println(function.apply(5, "5"));
    }

}
