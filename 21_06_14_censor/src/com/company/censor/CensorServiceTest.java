package com.company.censor;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;


public class CensorServiceTest {

    List<String> badWords = Arrays.asList("fff", "hhh", "ddd", "nnn", "ccc", "JJJ");
    String text = "I want fff to go to fff and what can I hhh g ddd what want ddd jjj CCC";
    CensorService censorService = new CensorService();

    @Test
    public void test_badWordsV1() {
        List<String> strings = censorService.badWordsV1(text, badWords);
        assertEquals(5, strings.size());
        assertEquals(true, strings.contains("fff"));
        assertEquals(true, strings.contains("jjj"));
    }

    @Test
    public void test_badWordsV2() {
        List<String> strings = censorService.badWordsV2(text, badWords);
        assertEquals(5, strings.size());
        assertEquals(true, strings.contains("fff"));
        assertEquals(true, strings.contains("jjj"));
    }
}
