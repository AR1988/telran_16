package com.company;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;

import static org.junit.Assert.*;


public class HwTest {

    @Test
    public void test_groupingSize_result_of_map_size() {
        TreeMap<String, TreeSet<String>> result = Hw.groupingTextByFirstChar("What is Java");
        assertEquals(3, result.size());
    }

    @Test
    public void test_keyExist() {
        TreeMap<String, TreeSet<String>> result = Hw.groupingTextByFirstChar("is");
        assertEquals(true, result.containsKey("i"));
        assertEquals(1, result.get("i").size());
        assertEquals(1, result.size());
    }


    @Test
    public void test_keyExist_textUpperCase() {
        TreeMap<String, TreeSet<String>> result = Hw.groupingTextByFirstChar("IS");

        try {
            assertEquals(true, result.containsKey("i"));
        } catch (AssertionError error) {
            System.out.println("error bla bla");
            fail();
        }
        assertEquals(1, result.size());
    }

    @Test
    public void test_value_hasTwoElementsByOneKey() {
        TreeMap<String, TreeSet<String>> result = Hw.groupingTextByFirstChar("is is2 is");
        assertEquals(2, result.get("i").size());
        assertEquals(1, result.size());
    }

    @Test
    public void test_value_hasNotRepeatElementsByOneKey() {
        TreeMap<String, TreeSet<String>> result = Hw.groupingTextByFirstChar("is is is is");
        assertEquals(1, result.get("i").size());
        assertEquals(1, result.size());
    }
}
