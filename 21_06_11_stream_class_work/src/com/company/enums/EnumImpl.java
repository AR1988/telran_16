package com.company.enums;

public class EnumImpl {

    public static void main(String[] args) {
        Music music = Music.POP;
        System.out.println(music.getNumber());
        System.out.println(music.getName());

        System.out.println(Music.ROCK.getName());
        System.out.println(Music.ROCK.getNumber());
    }
}
