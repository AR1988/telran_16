package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExamStats {

//    Есть файл с датами экзаменов «exams.txt» (форматы дат 24-05 2021).
//    Пользователь вводит в консоль дату проверки (формат даты: 21.05.2021).
//    Далее программа выводит в консоль даты (формат вывода Mai, 21 2021) из файла со статусами.Статусы определяются по правилам:
//    1.   Если дата экзамена до даты проверки, то «wasn daysago»
//    2.   Если дата экзамена вчера, относительно даты проверки, то «wasyesterday»
//    3.   Если дата экзамена после даты проверки, то «inn days»
//    4.   Если дата экзамена завтра, относительно даты проверки, то «tomorrow»
//    5.   Если дата экзамена == дате проверки, то «today»
//    6.   *Если Пользователь вводит дату не верного формата, попросить ввести дату повторно.

    public static void main(String[] args) {
        String fileName = "exams.txt";
        List<String> stringsFromFile = readFile(fileName);

        List<LocalDate> localDatesFromFile = new ArrayList<>();
        for (String s : stringsFromFile) {
            LocalDate date = convertToLocalDate(s, "dd-MM yyyy");
            localDatesFromFile.add(date);
        }
        LocalDate dateFromConsole = readConsole();

        setStats(localDatesFromFile, dateFromConsole);
    }

//    selectedDay: 25, мая 2021
//    01, января 2020 was510 days ago
//    21, мая 2021was4 days ago
//    22, мая 2021 was3 day sago
//    23, мая 2021was2 days ago
//    24, мая 2021 yesterday day
//    25, мая 2021 today
//    26, мая 2021 tomorrow
//    27, мая 2021 in2days
//    28, мая 2021 in3days
//    29, мая 2021 in4days
//    01, января 2022 in221days

    private static void setStats(List<LocalDate> localDatesFromFile, LocalDate dateFromConsole) {

        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd, MMMM yyyy");
        for (LocalDate examDate : localDatesFromFile) {

            if (examDate.isBefore(dateFromConsole)) {
                long between = ChronoUnit.DAYS.between(examDate, dateFromConsole);
                String message = between == 1 ? " yesterday" : " was " + between + " ago";
                System.out.println(examDate.format(format) + message);
            } else if (examDate.isAfter(dateFromConsole)) {
                long between = ChronoUnit.DAYS.between(dateFromConsole, examDate);

//                if (between == 1) {
//                    String message = "tomorrow";
//                } else {
//                    String message = " in " + between + " days";
//                }

                String message = between == 1 ? " tomorrow" : " in " + between + " days";
                System.out.println(examDate.format(format) + message);
            } else {
                System.out.println(examDate.format(format) + " is today");
            }
        }
    }

    private static LocalDate readConsole() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("type date: ");

        while (true) {
            String line = scanner.nextLine();
            try {
                return convertToLocalDate(line, "dd.MM.yyyy");
            } catch (DateTimeParseException e) {
                System.out.println("invalid input format, valid date format is dd.MM.yyyy");
            }
        }
    }

    private static LocalDate convertToLocalDate(String stringToParse, String format) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        return LocalDate.parse(stringToParse, formatter);
    }

    private static List<String> readFile(String fileName) {
        List<String> list = new ArrayList<>();
        try {

            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                list.add(line);
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }
}
