package com.company.worker;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class WorkerService {
    //1. Поделить рабочих на тех кто зарабатывает меньше 3000 и тех кто зарабатывает больше 3000
    //2. Сгруппировать список рабочих по их должности
    //3. Подсчитать количество рабочих, занимаемых конкретную должность (counting)
    //4. Сгруппировать список рабочих по их возрасту, внести в список только тех, кто старше 31.
    //5. Суммировать зарплаты всех работников по должностям

    public Map<Boolean, List<Worker>> partitioningBySalary(List<Worker> workers) {
        return workers
                .stream()
                .collect(Collectors.partitioningBy(worker -> worker.getSalary() > 3000));
    }

    public Map<String, List<Worker>> groupingByPosition(List<Worker> workers) {
        return workers
                .stream()
//                .collect(Collectors.groupingBy(Worker::getPosition, Collectors.toList()));
//                .collect(Collectors.groupingBy(Worker::getPosition, Collectors.toCollection(LinkedList::new)));
                .collect(Collectors.groupingBy(Worker::getPosition));
    }

    public Map<String, Long> workersByPosition(List<Worker> workers) {
        return workers
                .stream()
                .collect(Collectors.groupingBy(Worker::getPosition, Collectors.counting()));
    }

    public Map<Integer, List<Worker>> groupingByAge(List<Worker> workers) {
        return workers
                .stream()
                .filter(worker -> worker.getAge() > 31)
                .collect(Collectors.groupingBy(Worker::getAge));
    }

    public Map<String, Long> groupingByPositionAndTotalSalary(List<Worker> workers) {
        return workers
                .stream()
                .collect(Collectors.groupingBy(worker -> worker.getPosition(), Collectors.summingLong(worker -> worker.getSalary())));
    }

}
