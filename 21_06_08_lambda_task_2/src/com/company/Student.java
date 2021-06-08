package com.company;

public class Student {
    private String name;
    private int examGrade;

    public Student(String name, int examGrade) {
        this.name = name;
        this.examGrade = examGrade;
    }

    public String getName() {
        return name;
    }

    public int getExamGrade() {
        return examGrade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", examGrade=" + examGrade +
                '}';
    }
}
