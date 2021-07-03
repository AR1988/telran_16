package com.company;

public class Main {
    //TODO config reader
    public static void main(String[] args) {
        // write your code here

        //запуск потоков

        //запуск чистилщика в отдельном потоке
        //Каждую секунду будут удаляться из списка сервера, которые не активны более 1 секунды
        Cleaner cleaner = new Cleaner(source, 1000);
        new Thread(cleaner).start();
    }
}
