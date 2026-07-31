package com.springcore.javaconfig;

public class Student {

    private Laptop laptop;

    public Student(Laptop laptop) {

        this.laptop = laptop;

        System.out.println("Student Object Created");
        System.out.println("Student received Laptop : "
                + laptop.hashCode());

    }

    public void study() {

        System.out.println("Student is Studying");

        laptop.compile();

    }

}