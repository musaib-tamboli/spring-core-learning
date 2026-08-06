package com.springcore.stereotype.entity;

public class Student {

    private int id;
    private String name;

    public Student(int id, String name) {

        this.id = id;
        this.name = name;

    }

    public String getName() {
        return name;
    }

}