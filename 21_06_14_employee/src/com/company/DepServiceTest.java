package com.company;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class DepServiceTest {
    DepService depService = new DepService();

    Employee emp1 = new Employee("Marina", 3000);
    Employee emp2 = new Employee("Falco", 1000);
    Employee emp3 = new Employee("Maria", 2500);

    Employee emp4 = new Employee("Marina", 5000);
    Employee emp5 = new Employee("Marina", 2000);
    Employee emp6 = new Employee("Roman", 2500);

    Employee emp7 = new Employee("Sergey", 3200);
    Employee emp8 = new Employee("Angela", 1800);
    Employee emp9 = new Employee("Larisa", 3000);

    Employee emp10 = new Employee("Petya", 3200);
    Employee emp11 = new Employee("Roza", 2500);
    Employee emp12 = new Employee("Sveta", 1299);

    List<Employee> list1 = Arrays.asList(emp1, emp2, emp3);
    List<Employee> list2 = Arrays.asList(emp4, emp5, emp6);
    List<Employee> list3 = Arrays.asList(emp7, emp8, emp9);
    List<Employee> list4 = Arrays.asList(emp10, emp11, emp12);

    Department department1 = new Department("It", "111-6", list3);
    Department department2 = new Department("Counting", "112-6", list1);
    Department department3 = new Department("Building", "111-9", list2);
    Department department4 = new Department("Analytics", "111-10", list4);

    List<Department> departments = Arrays.asList(department1, department2, department3, department4);

    @Test
    public void test_calcNumberOfEmployees() {
        assertEquals(4, depService.calcNumberOfEmployees(departments, 3000));
        assertEquals(1, depService.calcNumberOfEmployees(departments, 5000));
    }
}
