package com.company;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

public class Tasks {

    //1.Узнать день недели своего рождения
    //2.Узнать свой возраст в часах

    //3.Вывести актуальное время и дату в Египте с указанием часового пояса и вывести в изменённом формате: 2021 мая 31 23:55
    //EET ( ofPattern ("... v)
    //4.метод для изменения формата: новый формат даты «31 9 2021 23:55». Обратите внимание, что не 09, а именно 9
    //5.метод для распарсивания строки в дату: строка 31_09_21 23_55 формат распарсеной даты: 2021 09 31 23:55

    //6.Есть дата 2021 03 31 23:55. Задача : получить дату «2022 12 31 10:00», прибавив к первой дате необходимое количество
    //часов, дней и прочего.

    //7.Посчитать сколько целых недель в месяце (целая неделя это неделя с пн вс)
    //8.Узнать время в NY относительно времени в Берлине. К примеру, в Берлине 16:00 то в NY 10:00 и наоборот
    public static void main(String[] args) {
//        task1();
//        task2();
//        task3();
//        task4();
//        task5("31_09_21-23_55");
//        task6();
        task7(LocalDate.now());
//        task8();
    }

    //    Узнать время в NY относительно времени в Берлине. К примеру, в Берлине 16:00 то в NY 10:00 и наоборот
    private static void task8() {
        LocalTime time = LocalTime.of(23, 20);

        ZonedDateTime berlinTime = ZonedDateTime.of(LocalDate.now(), time, ZoneId.of("Europe/Berlin"));
        ZonedDateTime nyTime = berlinTime.withZoneSameInstant(ZoneId.of("America/New_York"));

        System.out.println(berlinTime);
        System.out.println(nyTime);

        nyTime = ZonedDateTime.of(LocalDate.now(), time, ZoneId.of("America/New_York"));
        berlinTime = nyTime.withZoneSameInstant(ZoneId.of("Europe/Berlin"));
        System.out.println("-----");
        System.out.println(nyTime);
        System.out.println(berlinTime);

    }

    //    Посчитать сколько целых недель в месяце (целая неделя это неделя с пн вс)
    private static void task7(LocalDate date) {
        LocalDate firstDayOfMonth = date.with(TemporalAdjusters.firstDayOfMonth());
        LocalDate firstMoOfMonth = firstDayOfMonth.with(TemporalAdjusters.nextOrSame(DayOfWeek.MONDAY));

        LocalDate lastDayOfMonth = date.with(TemporalAdjusters.lastDayOfMonth());
        LocalDate lastSundayOfMonth = lastDayOfMonth.with(TemporalAdjusters.previousOrSame(DayOfWeek.SUNDAY)).plusDays(1);

        long diffW = ChronoUnit.WEEKS.between(firstMoOfMonth, lastSundayOfMonth);
        System.out.println(diffW);
    }

    //Есть дата 2021 03 31 23:55. Задача : получить дату «2022 12 31 10:00», прибавив к первой дате необходимое количество
    private static void task6() {
        LocalDateTime localDateTime1 = LocalDateTime.of(2021, 3, 31, 10, 0);
        LocalDateTime localDateTime2 = LocalDateTime.of(2022, 12, 31, 10, 0);

        long diff = ChronoUnit.SECONDS.between(localDateTime1, localDateTime2);
        System.out.println(localDateTime1.plusSeconds(diff));
        System.out.println(localDateTime1.plusSeconds(diff).equals(localDateTime2));
    }


    //5.метод для распарсивания строки в дату: строка 31_09_21-23_55 формат распарсеной даты: 2021 09 31 23:55
    private static void task5(String dateString) {
        DateTimeFormatter formatterToParse = DateTimeFormatter.ofPattern("dd_MM_yy-HH_mm");
        LocalDateTime parsedDate = LocalDateTime.parse(dateString, formatterToParse);
        System.out.println(parsedDate);

        DateTimeFormatter newFormatter = DateTimeFormatter.ofPattern("yyyy MM dd HH:mm");
        System.out.println(parsedDate.format(newFormatter));
    }


    //4.метод для изменения формата: новый формат даты «31 9 2021 23:55». Обратите внимание, что не 09, а именно 9
    private static void task4() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd M yyyy HH:mm");
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now.format(formatter));
    }

    //3.Вывести актуальное время и дату в Египте с указанием часового пояса и вывести в изменённом формате: 2021 мая 31 23:55
    //EET ( ofPattern ("... v)
    private static void task3() {
        ZoneId zoneCairo = ZoneId.of("Europe/Moscow");
        ZonedDateTime moscowTime = ZonedDateTime.now(zoneCairo);
        System.out.println(moscowTime);

        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy MMMM dd HH:mm z");
        System.out.println(moscowTime.format(format));
//        System.out.println(moscowTime.format(DateTimeFormatter.ofPattern("yyy MMMM dd HH:mm v")));
    }

    //2.Узнать свой возраст в часах
    private static void task2() {
        LocalDateTime myBD = LocalDateTime.of(1988, 9, 22, 7, 0);
        LocalDateTime now = LocalDateTime.now();
        long diff = ChronoUnit.HOURS.between(myBD, now);
//        long diff = ChronoUnit.HOURS.between(now, myBD);
        System.out.println(diff);
    }

    //1.Узнать день недели своего рождения
    private static void task1() {
        LocalDateTime myBD = LocalDateTime.of(1988, 9, 22, 7, 0);
        System.out.println(myBD.getDayOfWeek());
    }
}
