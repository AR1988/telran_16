package com.company;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

public class Main {

    public static void main(String[] args) {
        ZoneId zoneId = ZoneId.of("America/Marigot");

        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();
//        ZonedDateTime zonedDateTime = ZonedDateTime.of(localDateTime, zoneId);

//        System.out.println(ZoneId.getAvailableZoneIds());
//        System.out.println(ZoneId.SHORT_IDS);
        System.out.println(localDateTime);
        System.out.println(zonedDateTime);
//        System.out.println(zonedDateTime.plusDays(2));
//        System.out.println(zonedDateTime.plusDays(2).plusMonths(5).plusMinutes(150).plusDays(10));

        DateTimeFormatter newFormat = DateTimeFormatter.ofPattern("dd.MM.yy HH:mm v");
        System.out.println(zonedDateTime.format(newFormat));

        String toParse = "22.09.21 23:59 CET";
        System.out.println(ZonedDateTime.parse(toParse, newFormat));
    }
}
