package com.company;


import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class LambdaTaskTest {

    List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);

    @Test
    public void testTask1_result_ok() {
        double expectedResult = 12;
        double result = LambdaTask.task1(1, 2, 3, 2);
        assertEquals(expectedResult, result, 1.5);
    }

    @Test
    public void testTask1_inputNegative_result_ok() {
        double expectedResult = 8;
        double result = LambdaTask.task1(-1, 2, 3, 2);
        assertEquals(expectedResult, result, 1.5);
    }

    @Test
    public void testTask1_multiply_to_0_result_ok() {
        double expectedResult = 0;
        double result = LambdaTask.task1(1, 2, 3, 0);
        assertEquals(expectedResult, result, 1.5);
    }

    @Test
    public void testTask2_parseStr200ToLong() {
        long expectedResult = 400;
        long result = LambdaTask.task2("200");
        assertEquals(expectedResult, result);
    }

    @Test(expected = NumberFormatException.class)
    public void testTask2_parseException_exceptionExpect() {
        LambdaTask.task2("asd");
    }

    @Test(expected = NumberFormatException.class)
    public void testTask2_parseExceptionInputDouble_exceptionExpect() {
        LambdaTask.task2("2.5");
    }

//    @Test
//    public void testTask3_sameList_expected() {
//        List<Integer> result = LambdaTask.evaluate(list, (num) -> true);
//        assertEquals(list.size(), result.size());
//        assertEquals(list, result);
//    }
//
//    @Test
//    public void testTask3_noElementsInList_listBlank() {
//        List<Integer> result = LambdaTask.evaluate(list, (num) -> false);
//        assertEquals(0, result.size());
////        assertTrue(list.equals(result));
//    }

//    @Test()
//    public void testTask2_parseException_exceptionExpect() {
//        try {
//            LambdaTask.task2("asd");
//        } catch (NumberFormatException e) {
//            assertTrue(true);
//        }
//        fail();
//    }
}
