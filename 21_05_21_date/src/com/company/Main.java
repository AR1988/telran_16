package com.company;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

public class Main {

    public static void main(String[] args) {
// Local Date
        LocalDate now = LocalDate.now();

//        // format: yyyy-MM-dd - 2021-05-21
//        System.out.println(now);
//        LocalDate nowPlusTenDays = now.plusDays(10);
//        System.out.println(nowPlusTenDays);
//        LocalDate nowMinusTenDays = now.minusDays(10);
//        System.out.println(nowMinusTenDays);
//
//        System.out.println(ZoneId.getAvailableZoneIds());
//
//        LocalDate dateOf = LocalDate.of(2021, 9, 22);
//        System.out.println(dateOf);
//        System.out.println(dateOf.getDayOfWeek());
//
//        System.out.println(dateOf.isAfter(now)); // true
//        System.out.println(dateOf.isBefore(now)); // false
//        System.out.println(now.isEqual(now)); // true
//
//        System.out.println(dateOf.plus(5, ChronoUnit.YEARS));
//        System.out.println(dateOf.plusYears(5));
//        System.out.println(dateOf.plus(Period.ofYears(5)));
//
//        Period period = Period.between(now, dateOf); //P-4M-1D
//        System.out.println(period);
//        System.out.println(period.getDays());
//        System.out.println(period.getMonths());
//
//        long periodWithChronoUnit = ChronoUnit.DAYS.between(now, dateOf);
//        System.out.println(periodWithChronoUnit);
//        LocalDate lastMo = now.with(TemporalAdjusters.previousOrSame(DayOfWeek.FRIDAY));
//        System.out.println(lastMo);
//
        LocalDate feb = LocalDate.of(2022, 2, 1);
//        LocalDate lastDayOfFeb = feb.with(TemporalAdjusters.lastDayOfMonth());
//        System.out.println(lastDayOfFeb);

//        System.out.println(getDaysFromAToBDates(now, now.plusYears(1).plusDays(1).plusMonths(1)));
//        System.out.println(daysToNewYears());
//        getLastDaysOfMonths(60);

// end LocalDate
//        LocalTime
        // format: HH-mm-ss-zzz - 11:55:33.638009900
        LocalTime localTimeNow = LocalTime.now();
//        LocalTime.of(12, 55);
//        LocalTime localTimeNowZoneInSydney = LocalTime.now(ZoneId.of("Australia/Sydney"));
//        System.out.println(ZoneId.getAvailableZoneIds());
//        System.out.println(localTimeNow);
//        System.out.println(localTimeNowZoneInSydney);
//
//        System.out.println(localTimeNow.plus(2, ChronoUnit.HOURS));
////        System.out.println(localTimeNow.plus(Duration.of(2, ChronoUnit.HOURS)));
//        Duration duration = Duration.between(localTimeNow, localTimeNowZoneInSydney);
//        System.out.println(duration);

        // LocalDateTime
        // format: yyyy-MM-ddTHH-mm-ss-zzz - 2021-05-21T11:55:33.638009900
        LocalDateTime localDateTime = LocalDateTime.of(now, localTimeNow);
        LocalDateTime localDateTimeNow = LocalDateTime.now();
//        System.out.println(localDateTime);
//        System.out.println(localDateTimeNow);
//
//        System.out.println(localDateTime.plus(5, ChronoUnit.DAYS));
//        System.out.println(localDateTime.plus(5, ChronoUnit.MINUTES));

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy - hh:mm");
        System.out.println(localDateTime.format(formatter));

        LocalDateTime dateSept = LocalDateTime.of(2021, 9, 15, 0, 0, 15);
        formatter = DateTimeFormatter.ofPattern("dd,MMMM yy - ss:hh:mm");
        System.out.println(dateSept.format(formatter));

        String str = "22_09......2020";
        DateTimeFormatter formatToParse = DateTimeFormatter.ofPattern("dd_MM......yyyy");
        LocalDate parsedDate = LocalDate.parse(str, formatToParse);
        System.out.println(parsedDate);

        String strWithTime = "22_09......2020 - 15:45:15";
        formatToParse = DateTimeFormatter.ofPattern("dd_MM......yyyy - HH:mm:ss");
        LocalDateTime parsedDateTime = LocalDateTime.parse(strWithTime, formatToParse);
        System.out.println(parsedDateTime);

    }


    //    разница в днях от from до даты to (LocalDate from, LocalDate to): long
    public static long getDaysFromAToBDates(LocalDate dateFrom, LocalDate dateTo) {
//        System.out.println(Period.between(dateFrom, dateTo));
//        System.out.println(Period.between(dateFrom, dateTo).getDays());
        return ChronoUnit.DAYS.between(dateFrom, dateTo);
    }


    //    сколько дней до празднования нового года (31.12.21) от сегодня (): long
    public static long daysToNewYears() {
        LocalDate now = LocalDate.now();
//        LocalDate endYear = LocalDate.of(2021, 12, 31);
        LocalDate endYear = now.with(TemporalAdjusters.lastDayOfYear());

        return getDaysFromAToBDates(now, endYear);
    }

    //    вывести в консоль последний день каждого месяца (int numberOfMonths): void
    public static void getLastDaysOfMonths(int monthsNumber) {
        LocalDate now = LocalDate.now();

        for (int i = 1; i <= monthsNumber; i++) {
            LocalDate dateToPrint = now.plusMonths(i);
            int lastDayOfMonth = dateToPrint.lengthOfMonth();
            System.out.print(lastDayOfMonth + " ");
        }
        System.out.println();
        for (int i = 1; i <= monthsNumber; i++) {
            LocalDate dateToPrint = now.plusMonths(i);
            System.out.print(dateToPrint.with(TemporalAdjusters.lastDayOfMonth()) + " ");
        }
    }
}


//      Дано: Вася ездиет на работу с пн - пт. Каждый день он выехжает в 6:00 и приезжает на работу в 7:00.
//      Расчитать сколько времени проводит василий в дороге на работу.


