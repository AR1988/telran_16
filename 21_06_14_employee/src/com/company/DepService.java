package com.company;

import java.util.List;

//Напишите метод с использованием Stream API
// ,который вычисляет общее количество сотрудников с зарплатой больше чем порог(threshold) каждого отдела,
// код которых(отделов) начинается со строки «111-» (без «»).
public class DepService {

    public long calcNumberOfEmployees(List<Department> departments, long threshold) {
        return departments
                .stream()
                .filter(department -> department.getCode().startsWith("111-"))
                .flatMap(department -> department.getEmployees().stream())
                .filter(employee -> employee.getSalary() >= threshold)
                .count();
    }
}
