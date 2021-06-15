package com.company.grouping;

import com.company.grouping.model.Phone;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;

public class GroupingByTest {

    List<Phone> phones;

    @Before
    public void init() {
        phones = Arrays.asList(
                new Phone("IPHONE X", "Apple", 600),
                new Phone("IPHONE 8", "Apple", 400),

                new Phone("Pixel 4a", "Google", 800),
                new Phone("Pixel 5", "Google", 1_000),

                new Phone("SGS-10+", "Samsung", 1_200),
                new Phone("SGS-10+", "Samsung", 2_200),
                new Phone("SGS-8", "Samsung", 600));
    }

    //группировка телефонов по компаниям
    @Test
    public void test_groupingByCompanyName() {
        Map<String, List<Phone>> map = phones
                .stream()
                .collect(Collectors.groupingBy(phone -> phone.getCompany()));

        assertEquals(3, map.size());

        assertEquals(2, map.get("Google").size());
        assertEquals(2, map.get("Apple").size());
        assertEquals(3, map.get("Samsung").size());

//        System.out.println("Apple: " + map.get("Apple"));
//        System.out.println("Google: " + map.get("Google"));
//        System.out.println("Samsung: " + map.get("Samsung"));
    }

    //группировка телефонов по именам
    @Test
    public void test_groupingByName() {
        Map<String, List<Phone>> map = phones
                .stream()
                .collect(Collectors.groupingBy(phone -> phone.getName()));

        assertEquals(6, map.size());
        assertEquals(1, map.get("IPHONE X").size());
        assertEquals(2, map.get("SGS-10+").size());
        assertEquals(1, map.get("IPHONE 8").size());
        System.out.println(map);
    }

    //группировка телефонов по цене
    @Test
    public void test_groupingByPrice() {
        Map<Integer, List<Phone>> map = phones
                .stream()
                .collect(Collectors.groupingBy(phone -> phone.getPrice()));

        assertEquals(6, map.size());
        assertEquals(2, map.get(600).size());
        assertEquals(1, map.get(800).size());
        assertEquals(1, map.get(400).size());
    }

    //partitioningBy
    @Test
    public void test_partitioningByPrice() {
        Map<Boolean, List<Phone>> map = phones
                .stream()
                .collect(Collectors.partitioningBy(phone -> phone.getPrice() > 800));

        assertEquals(2, map.size());
        assertEquals(4, map.get(false).size());
        assertEquals(3, map.get(true).size());
    }

    //метод коллектора summing Collectors.summing();
    @Test
    public void test_summingByPrice() {
        Map<String, Integer> map = phones
                .stream()
                .collect(
                        Collectors.groupingBy(phone -> phone.getCompany(), Collectors.summingInt(value -> value.getPrice()))
                );

        assertEquals(3, map.size());
        assertEquals(1800L, (long) map.get("Google"));
        assertEquals(4000, (long) map.get("Samsung"));
    }

    //метод коллектора summing Collectors.counting();
    @Test
    public void test_countingByPrice() {
        Map<String, Long> map = phones
                .stream()
                .collect(
                        Collectors.groupingBy(phone -> phone.getCompany(), Collectors.counting()));

        assertEquals(3, map.size());
        assertEquals(2, (long) map.get("Google"));
        assertEquals(3, (long) map.get("Samsung"));
    }
}
