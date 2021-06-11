package com.company.stram_reduce;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * В Java 8 потоки не могут быть использованы повторно. После вызова любого терминального метода поток завершается:
 */
public class StreamReduce {

    public static void main(String[] args) throws Exception {
        IntStream intStream = IntStream.rangeClosed(1, 6);
        int resultStream = intStream.reduce(
                (result, element) -> result * element)
                .getAsInt();
        //result =  1   2   6   24  120 720
        //element = 2   3   4   5   6
        System.out.println(resultStream);

        IntStream intStream2 = IntStream.rangeClosed(10, 12);
        int resultStream2 = intStream2
                .reduce(
                        (result, element) -> result * element)
                .orElseThrow(() -> new Exception("intStream2 reduce exception, no element is present"));
        //result =  10  110 1320
        //element = 11   12
        System.out.println(resultStream2);

//        List<Integer> integers2 = Arrays.asList(1, 2, 3, 4, 5);
//        int resultLoop = integers2.get(0);
//        for (Integer integer : integers2) {
//            resultLoop = resultLoop * integer;
//        }

//Optional.class
//        List<Integer> list = Arrays.asList();
        List<Integer> list = Arrays.asList(1, 2, 3);
        Optional<Integer> optional = list.stream()
                .reduce((result, element) -> result * element);

        System.out.println(optional.orElse(999));
        optional.orElseThrow(() -> new Exception("msg error"));

        if (optional.isPresent()) {
            System.out.println("integer is: " + optional.get());
        }

//end Optional

        IntStream intStream3 = IntStream.rangeClosed(1, 5);
        int streamResult3 = intStream3
                .reduce(10, (result, element) -> result * element);

        //result  = 10 10 20 60 240
        //element =  1  2  3  4 5

//        List<Integer> integers2 = Arrays.asList(1, 2, 3, 4, 5);
//        int result2 = 10;
//        for (Integer integer : list) {
//            result2 = result2 * integer;
//        }

        Stream<String> stringStream = Stream.of("Hi", "World", "my", "name", "is", "iasdas", "iAsd");
        String strResult = stringStream
                .filter(s -> s.startsWith("i"))
                .map(s -> s + " AMAMAM")
                .reduce("String result ", (s, s2) -> s + s2);
        System.out.println(strResult);
    }
}
