package com.company.worker;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class WorkerServiceTest {

    List<Worker> workers;
    WorkerService workerService = new WorkerService();

    @Before
    public void setUp() {
        workers = Arrays.asList(
                new Worker("Max", 35, 2500, "Junior Developer"),
                new Worker("Erich", 33, 2400, "Junior Developer"),
                new Worker("Emily", 31, 2850, "Middle Developer"),
                new Worker("Felix", 34, 3500, "Senior Developer"),

                new Worker("Mark", 35, 4000, "Project Manager"),
                new Worker("Petr", 32, 4200, "Team Lead"),

                new Worker("Maria", 24, 1900, "HR"),
                new Worker("Sofia", 25, 1950, "HR"),
                new Worker("Kate", 20, 2200, "QA")
        );
    }

    @Test
    public void test_groupBySalary() {
        Map<Boolean, List<Worker>> result = workerService.partitioningBySalary(workers);
        assertEquals(3, result.get(true).size());
        assertEquals(6, result.get(false).size());
    }

    @Test
    public void test_groupByPosition() {
        Map<String, List<Worker>> result = workerService.groupingByPosition(workers);
        assertEquals(2, result.get("Junior Developer").size());
        assertEquals(2, result.get("HR").size());
        assertEquals(1, result.get("QA").size());

        List<Worker> workerList = result.get("HR");
        for (Worker worker : workerList) {
            System.out.println(worker);
        }
        for (int i = 0; i < workerList.size(); i++) {
            System.out.println(workerList.get(i));
        }
//        workerList.stream().forEach(worker -> System.out.println(worker));
    }

    @Ignore
    @Test
    public void test_quantityWorkersOfPosition() {
    }

    @Ignore
    @Test
    public void test_groupByAge() {
    }

    @Ignore
    @Test
    public void test_getSalarySumOfPosition() {
    }
}
